package com.example.MyProduct.controllers;

import com.example.MyProduct.models.Supplies;
import com.example.MyProduct.services.SuppliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SuppliesController {
    private final SuppliesService suppliesService;


    @PostMapping("/supplier/create")
    public ResponseEntity<String> createProduct(@RequestBody Supplies supplies) {
        suppliesService.supplyProduct(supplies);
        return ResponseEntity.ok()
                .body("Покупка успешна!");
    }


}
