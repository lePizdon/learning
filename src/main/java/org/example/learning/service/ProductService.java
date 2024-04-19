package org.example.learning.service;

import org.example.learning.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(Integer id);

    void updateProduct(Integer id, String title, String details);

    void deleteProduct(Integer id);
}
