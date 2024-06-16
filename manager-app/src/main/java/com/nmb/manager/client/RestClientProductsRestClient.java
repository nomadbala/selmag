package com.nmb.manager.client;

import com.nmb.manager.controller.payload.NewProductPayload;
import com.nmb.manager.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientProductsRestClient implements ProductsRestClient {

    private static final ParameterizedTypeReference<List<Product>> PRODUCTS_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};

    private final RestClient restClient;

    @Override
    public List<Product> findAllProducts() {
        return restClient.get()
                .uri("/catalogue-api/products")
                .retrieve() // Получить ответ
                .body(PRODUCTS_TYPE_REFERENCE);
    }

    @Override
    public Product createProduct(String title, String details) {
        restClient.post()
                .uri("/catalogue-api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new NewProductPayload(title, details))
                .retrieve()
                .body(Product.class);
    }

    @Override
    public Optional<Product> findProduct(int productId) {
        return Optional.empty();
    }
-
    @Override
    public void updateProduct(int productId, String title, String details) {

    }

    @Override
    public void deleteProduct(int productId) {

    }
}
