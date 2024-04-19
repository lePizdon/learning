package org.example.learning.service;

import lombok.RequiredArgsConstructor;
import org.example.learning.entity.Product;
import org.example.learning.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void updateProduct(Integer id, String title, String details) {
       this.productRepository.findById(id)
               .ifPresentOrElse(product -> {
                   product.setTitle(title);
                   product.setDetails(details);
               }, () -> {
                   throw new NoSuchElementException();
               });
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }
}
