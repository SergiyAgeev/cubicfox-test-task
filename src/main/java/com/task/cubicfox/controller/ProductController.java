package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.service.ProductService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // products?page=value&limit=value
    @GetMapping
    public Collection<Product> getAllProducts(@RequestParam(value = "page",
            required = false,
            defaultValue = "0") Integer page,
                                              @RequestParam(value = "limit",
                                                      required = false,
                                                      defaultValue = "20") Integer limit) {
        Pageable pageRequest = PageRequest.of(page, limit);
        return productService.findAll(pageRequest);
    }
}
