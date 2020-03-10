package com.task.cubicfox.repository;

import com.task.cubicfox.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Product, Long> {
}
