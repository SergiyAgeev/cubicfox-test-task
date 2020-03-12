package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.repository.ProductRepository;
import com.task.cubicfox.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServicceImpl implements ProductService {
    final
    ProductRepository productRepository;

    public ProductServicceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getOne(id);
    }
}
