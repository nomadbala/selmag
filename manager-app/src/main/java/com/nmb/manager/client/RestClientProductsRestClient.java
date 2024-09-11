package com.nmb.manager.client;

import com.nmb.manager.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientProductsRestClient implements ProductsRestClient {
    private final RestClient restClient;

    private static final ParameterizedTypeReference

    @Override
    public List<Product> findAllProducts() {
        return this.restClient
                .get()
                .uri("/catalogue-api/products")
                .retrieve()
                .
    }

    @Override
    public Product createProduct(String title, String details) {
        return null;
    }

    @Override
    public Optional<Product> findProduct(Long productId) {
        return Optional.empty();
    }

    @Override
    public void updateProduct(Long productId, String title, String details) {

    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
