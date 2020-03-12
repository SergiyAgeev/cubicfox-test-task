package com.task.cubicfox.repository;

import com.task.cubicfox.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.code LIKE %?1%")
    Page<Product> getByCode(String code, Pageable pageable);

    @Query("UPDATE Product p SET p.name= ?1, p.description =?2, p.price = ?3 WHERE p.id = ?4")
    void updateById(String name, String description, Double prise, Long id);
}
