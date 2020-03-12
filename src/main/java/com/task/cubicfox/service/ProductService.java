package com.task.cubicfox.service;

import com.task.cubicfox.entity.Product;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ProductService {
    void save(Product product);

    List<Product> findAll(Pageable pageable);

    Product getById(Long id);
}
