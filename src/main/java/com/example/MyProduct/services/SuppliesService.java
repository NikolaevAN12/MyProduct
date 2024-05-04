package com.example.MyProduct.services;

import com.example.MyProduct.models.Product;
import com.example.MyProduct.models.Supplies;
import com.example.MyProduct.repositories.ProductRepository;
import com.example.MyProduct.repositories.SuppliesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SuppliesService {
    private final ProductRepository productRepository;
    private final SuppliesRepository suppliesRepository;

    public void supplyProduct(Supplies supplies) {
        Product product = productRepository.findById(supplies.getProduct().getId()).orElseThrow();
        suppliesRepository.save(supplies);
        product.setAvailable(true);
        productRepository.save(product);

    }

}
