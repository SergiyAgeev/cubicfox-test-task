package com.task.cubicfox.repository;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.code LIKE %?1%")
    Page<Product> getByCode(String code, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Product p SET p.name= ?1, p.description =?2, p.price = ?3,"
            + " p.status = ?4 WHERE p.id = ?5")
    void updateById(String name, String description, Double prise, Status status, Long id);

    @Query("SELECT p, AVG (r.rate) FROM Product p JOIN Rate r ON p.id = r.id WHERE p.id = ?1")
    Product getDetailedProduct(Long id);
}
