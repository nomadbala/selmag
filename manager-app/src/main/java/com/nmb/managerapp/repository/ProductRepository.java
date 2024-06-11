package com.nmb.managerapp.repository;

import com.nmb.managerapp.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
