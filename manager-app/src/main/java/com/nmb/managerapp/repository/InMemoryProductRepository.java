package com.nmb.managerapp.repository;

import com.nmb.managerapp.entity.Product;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.*;
=======
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
import java.util.stream.IntStream;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

<<<<<<< HEAD
=======
    public InMemoryProductRepository() {
        IntStream.range(1, 4)
                .forEach(i -> products.add(new Product(i, "Товар %d".formatted(i), "Описание %d".formatted(i))));
    }

>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }
<<<<<<< HEAD

    @Override
    public Product save(Product product) {
        product.setId(products.stream().max(Comparator.comparingInt(Product::getId))
                .map(Product::getId)
                .orElse(0) + 1);

        products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return products.stream()
                .filter(product -> Objects.equals(productId, product.getId()))
                .findFirst();
    }
=======
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
}
