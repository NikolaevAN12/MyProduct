package com.example.MyProduct.services;

import com.example.MyProduct.models.Product;
import com.example.MyProduct.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {/*Получение всего списка*/
        if (title != null)
            return productRepository.findByTitle(title);
        return productRepository.findAll();
    }


    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product product) {
        productRepository.findById(id).ifPresent(p -> {
            BeanUtils.copyProperties(product, p);
            productRepository.save(product);
        });
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}



