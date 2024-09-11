package com.nmb.catalogue.service;


import com.nmb.catalogue.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(long productId);

    void updateProduct(Long id, String title, String details);

    void deleteProduct(Long id);
}
