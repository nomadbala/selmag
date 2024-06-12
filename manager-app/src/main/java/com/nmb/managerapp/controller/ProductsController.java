package com.nmb.managerapp.controller;

<<<<<<< HEAD
import com.nmb.managerapp.controller.payload.NewProductPayload;
import com.nmb.managerapp.entity.Product;
=======
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
import com.nmb.managerapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {
    private final ProductService productService;

<<<<<<< HEAD
    @GetMapping("list")
=======
    @RequestMapping(value = "list", method = RequestMethod.GET)
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
    public String getProductsList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "catalogue/products/list";
    }

<<<<<<< HEAD
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

=======
>>>>>>> 41258dda3ced627aca7ab3447c713be34f161109
}
