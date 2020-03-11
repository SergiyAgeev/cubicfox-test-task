package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.repository.ProductRepository;
import com.task.cubicfox.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
