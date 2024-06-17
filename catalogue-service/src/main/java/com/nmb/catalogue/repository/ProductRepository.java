package com.nmb.catalogue.repository;

import com.nmb.catalogue.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findAllByTitleLikeIgnoreCase(String filter);
}
