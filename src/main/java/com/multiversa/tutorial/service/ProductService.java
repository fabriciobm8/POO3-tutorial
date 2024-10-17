package com.multiversa.tutorial.service;

import com.multiversa.tutorial.model.Product;
import com.multiversa.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  // Método para salvar um produto no banco de dados
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  //Método para obter um produto específico pelo seu ID
  public Product getProduct(long productId) {
    return productRepository.findById(productId).orElseThrow(() -> new
        RuntimeException("Produto não encontrado"));
  }

  //Método para obter todos os produtos no banco de dados
  public List<Product> getProducts() {
    return productRepository.findAll();
  }


  //Método para atualizar um produto existente no banco de dados
  public Product updateProduct(long productId, Product product) {
    Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new
        RuntimeException("Produto não encontrado"));
    existingProduct.setProductName(product.getProductName());
    existingProduct.setColor(product.getColor());
    existingProduct.setPrice(product.getPrice());
    productRepository.save(existingProduct);
    return existingProduct;
  }

  //Método para excluir um produto existente no banco de dados
  public Product deleteProduct(long productId) {
    Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new
        RuntimeException("Produto não encontrado"));
    productRepository.deleteById(productId);
    return existingProduct;
  }

  //Método para obter produtos pelo nome usando uma consulta personalizada
  public List<Product> getProductsByName(String productName) {
    return productRepository.getProductsByName(productName);
  }
}