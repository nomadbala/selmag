package com.nmb.catalogue.controller;

import com.nmb.catalogue.controller.payload.NewProductPayload;
import com.nmb.catalogue.entity.Product;
import com.nmb.catalogue.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products")
public class ProductsRestController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody NewProductPayload payload, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        } else {
            productService.createProduct(payload.title(), payload.details());
        }
    }
}
