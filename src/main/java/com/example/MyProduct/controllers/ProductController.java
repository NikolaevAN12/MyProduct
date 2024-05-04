package com.example.MyProduct.controllers;

import com.example.MyProduct.models.Product;
import com.example.MyProduct.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @PostMapping("/product/update/{id}")
    public String updateProductById(@PathVariable Long id, Product product) {
        productService.updateProduct(id, product);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String filter(Model model, @RequestParam(required = false) String title, @RequestParam(required = false) Double priceStart, @RequestParam(required = false) Double priceEnd,
                         @RequestParam(required = false) Boolean available, @RequestParam(required = false) String sort, @RequestParam(required = false, defaultValue = "15") Integer limit) {

        List<Product> products = productService.findByFilter(title, priceStart, priceEnd, available, Sort.by(Sort.Direction.DESC, sort), limit);
        model.addAttribute("products", products);
        return "filter_results";
    }

}
