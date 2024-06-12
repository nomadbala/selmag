package com.nmb.managerapp.service;

import com.nmb.managerapp.entity.Product;
import com.nmb.managerapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
<<<<<<< HEAD

    @Override
    public Product createProduct(String title, String details) {
        return productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(int productId) {
        return productRepository.findById(productId);
    }
=======
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
}
