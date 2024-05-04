package com.example.MyProduct.repositories;

import com.example.MyProduct.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    @Query(value = "select sum(s.countSold) from Sales s where s.product.id=:productId")
    Optional<Integer> findCountByProductId(Long productId);
    void  deleteAllByProductId(Long productId);
}
