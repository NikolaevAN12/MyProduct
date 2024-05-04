package com.example.MyProduct.repositories;

import com.example.MyProduct.models.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SuppliesRepository extends JpaRepository<Supplies, Long> {
    @Query(value = "select sum(s.countBought) from Supplies s where s.product.id=:productId")
    Optional<Integer> findCountByProductId(Long productId);
    void  deleteAllByProductId(Long productId);

}
