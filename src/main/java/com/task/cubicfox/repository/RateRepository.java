package com.task.cubicfox.repository;

import com.task.cubicfox.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query("SELECT AVG(r.rate) FROM Rate r WHERE r.product.id =?1")
    Double getRateByProductId(Long productId);
}
