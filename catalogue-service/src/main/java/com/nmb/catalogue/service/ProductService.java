package com.nmb.catalogue.service;

import com.nmb.catalogue.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAllProducts(String filter);

    Product createProduct(String title, String details);

    Optional<Product> findProduct(int productId);

    void updateProduct(Integer id, String title, String details);

    void deleteProduct(Integer id);
}
