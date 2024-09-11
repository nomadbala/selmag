package com.nmb.catalogue.repository;

import com.nmb.catalogue.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = Collections.synchronizedList(new LinkedList<>());

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product save(Product product) {
        product.setId(
                products
                        .stream()
                        .max(Comparator.comparingLong(Product::getId))
                        .map(Product::getId)
                        .orElse(0L) + 1
        );

        products.add(product);

        return product;
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return products
                .stream()
                .filter(product -> Objects.equals(productId, product.getId()))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(product -> Objects.equals(id, product.getId()));
    }
}
