package com.example.MyProduct.repositories;

import com.example.MyProduct.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    @Query(value = "SELECT a FROM Product a WHERE (LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL OR :title = '') " +
            "and (a.price between :priceStart AND :priceEnd or ( :priceStart IS NULL AND :priceEnd IS NULL))  " +
            "and (a.available = :avaliable or :avaliable IS NULL) "
    )
    List<Product> findByFilter(String title, Double priceStart, Double priceEnd, Boolean avaliable, Sort sort);
}
