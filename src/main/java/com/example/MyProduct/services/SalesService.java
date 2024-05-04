package com.example.MyProduct.services;

import com.example.MyProduct.models.Product;
import com.example.MyProduct.models.Sales;
import com.example.MyProduct.repositories.ProductRepository;
import com.example.MyProduct.repositories.SalesRepository;
import com.example.MyProduct.repositories.SuppliesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SalesService {
    private final SalesRepository salesRepository;
    private final ProductRepository productRepository;
    private final SuppliesRepository suppliesRepository;

    public ResponseEntity<String> saleProduct(Sales sales) {
        Product product = productRepository.findById(sales.getProduct().getId()).orElseThrow();
        if (product.isAvailable()) {
            int countBought = suppliesRepository.findCountByProductId(product.getId()).orElse(0);
            int countSold = salesRepository.findCountByProductId(product.getId()).orElse(0);
            int countAvalible = countBought - countSold - sales.getCountSold();
            if (countAvalible >= 0) {
                log.info("Saving new {}", sales);
                salesRepository.save(sales);
                if (countAvalible == 0) {
                    product.setAvailable(false);
                    productRepository.save(product);
                }
                return ResponseEntity.ok("Продажа успешна! Колличество продукции: " + countAvalible);
            }

        }

        return ResponseEntity.badRequest().body("Продажа неуспешна!");
    }
}
