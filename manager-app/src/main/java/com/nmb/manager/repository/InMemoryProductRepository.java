package com.nmb.manager.repository;

import com.nmb.manager.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = Collections.synchronizedList(new LinkedList<>());
}
