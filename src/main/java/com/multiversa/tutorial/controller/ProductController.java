package com.multiversa.tutorial.controller;

import com.multiversa.tutorial.model.Product;
import com.multiversa.tutorial.service.ProductService; // vai dar erro por enquanto
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;
  @PostMapping("/product")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    Product savedProduct = productService.saveProduct(product);
    return ResponseEntity.ok(savedProduct);
  }
  @GetMapping("/product/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable long id) {
    Product product = productService.getProduct(id);
    return ResponseEntity.ok(product);
  }
  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return productService.getProducts();
  }
  @PutMapping("/product/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody
  Product product) {
    Product updatedProduct = productService.updateProduct(id, product);
    return ResponseEntity.ok(updatedProduct);
  }
  @DeleteMapping("/product/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }
  @GetMapping("/products-by-name")
  public List<Product> getProductsByName(@RequestParam String name) {
    return productService.getProductsByName(name);
  }
  @GetMapping("/products-by-name2/{name}")
  public List<Product> getProductsByName2(@PathVariable String name) {
    return productService.getProductsByName(name);
  }

}