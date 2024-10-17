package com.multiversa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.multiversa.tutorial.model.Product;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {

  // Consulta personalizada para obter produtos pelo nome
  @Query(value = "SELECT * FROM product_inventory WHERE product_name = ?1",
      nativeQuery = true)
  List<Product> getProductsByName(String productName);
}