package com.task.cubicfox.service;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.dto.response.ProductResponseDto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    void save(Product product);

    List<Product> findAll(Pageable pageable);

    Product getById(Long id);

    void update(Long id, Product product);

    Page<Product> getByCode(String code, Pageable pageable);
}
