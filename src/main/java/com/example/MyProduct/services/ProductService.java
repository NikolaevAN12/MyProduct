package com.example.MyProduct.services;

import com.example.MyProduct.models.Product;
import com.example.MyProduct.repositories.ProductRepository;
import com.example.MyProduct.repositories.SalesRepository;
import com.example.MyProduct.repositories.SuppliesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SalesRepository salesRepository;
    private final SuppliesRepository suppliesRepository;

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

    @Transactional
    public void deleteProduct(Long id) {
        salesRepository.deleteAllByProductId(id);
        suppliesRepository.deleteAllByProductId(id);
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findByFilter(String title, Double priceStart, Double priceEnd, Boolean available, Sort sort, Integer limit) {

        return productRepository.findByFilter(title, priceStart, priceEnd, available, sort).stream().limit(limit).collect(Collectors.toList());
    }


}
