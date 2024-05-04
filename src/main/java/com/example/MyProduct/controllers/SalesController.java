package com.example.MyProduct.controllers;


import com.example.MyProduct.models.Sales;
import com.example.MyProduct.services.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;

    @PostMapping("/sale/create")
    public ResponseEntity<String> createProduct(@RequestBody Sales sales) {
        return salesService.saleProduct(sales);
    }

}
