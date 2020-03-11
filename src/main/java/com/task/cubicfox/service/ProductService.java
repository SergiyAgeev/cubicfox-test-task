package com.task.cubicfox.service;

import com.task.cubicfox.entity.Product;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ProductService {
    public List<Product> findAll(Pageable pageable);
}
