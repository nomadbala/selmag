package com.nmb.manager.controller;

import com.nmb.manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;
}
