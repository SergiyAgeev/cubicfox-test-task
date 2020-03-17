package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.repository.ProductRepository;
import com.task.cubicfox.service.ProductService;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
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
        log.info("product with id = " + product.getId() + " was successfully saved.");
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        List<Product> products = productRepository.findAll(pageable).getContent();
        log.info("all products was successfully get, products count = " + products.size() + ".");
        return products;
    }

    @Override
    public Product getById(Long id) {
        Product one = productRepository.getOne(id);
        log.info("get product with id = " + id + "was successfully get.");
        return one;
    }

    @Override
    public void update(Long id, Product product) {
        productRepository.updateById(product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStatus(),
                id);
        log.info("product with id = " + product.getId()
                + "was successfully updated with user with id = " + id + ".");
    }

    @Override
    public Page<Product> getByCode(String code, Pageable pageable) {
        Page<Product> byCode = productRepository.getByCode(code, pageable);
        log.info("get product with code = " + code + "; was successfully get.");
        return byCode;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Product detailedProduct = productRepository.getDetailedProduct(id);
        log.info("getSingleProduct with id = " + id + "was successfully get.");
        return detailedProduct;
    }
}
