package com.nmb.managerapp.controller;

import com.nmb.managerapp.controller.payload.NewProductPayload;
import com.nmb.managerapp.entity.Product;
import com.nmb.managerapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {
    private final ProductService productService;

    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId) {
        return productService.findProduct(productId).orElseThrow();
    }

    @GetMapping("list")
    public String getProductsList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {
        Product product = productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }

    @GetMapping("{productId:\\d+}")
    public String getProduct(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }

    @GetMapping("{productId}:\\d+")
    public String getProductEditPage(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.findProduct(productId).orElseThrow());
        return "catalogue/products/edit";
    }
}
