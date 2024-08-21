package com.nmb.manager.service;

import com.nmb.manager.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(long productId);

    void updateProduct(Long id, String title, String details);
}
