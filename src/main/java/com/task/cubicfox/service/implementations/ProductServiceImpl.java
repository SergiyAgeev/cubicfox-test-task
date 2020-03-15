package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.dto.response.ProductResponseDto;
import com.task.cubicfox.repository.ProductRepository;
import com.task.cubicfox.service.ProductService;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        product.setCreateDate(new Date());
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

    @Override
    public void update(Long id, ProductResponseDto product) {
        productRepository.updateById(product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStatus(),
                id);
    }

    @Override
    public Page<Product> getByCode(String code, Pageable pageable) {
        return productRepository.getByCode(code, pageable);
    }
}
