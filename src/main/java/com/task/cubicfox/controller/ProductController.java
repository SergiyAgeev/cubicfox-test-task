package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.dto.response.ProductResponseDto;
import com.task.cubicfox.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // products?page=value&limit=value
    @GetMapping
    public List<ProductResponseDto> getAllProducts(@RequestParam(value = "page",
            required = false,
            defaultValue = "0") Integer page,
                                                   @RequestParam(value = "limit",
                                                           required = false,
                                                           defaultValue = "20") Integer limit) {
        Pageable pageRequest = PageRequest.of(page, limit);
        return productService.findAll(pageRequest).stream()
                .map(this::getProductResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    @RequestMapping("/{productID}")
    public ProductResponseDto getProductById(@PathVariable Long productID) {
        return getProductResponseDto(productService.getById(productID));
    }

    private ProductResponseDto getProductResponseDto(Product product) {
        ProductResponseDto productDto = new ProductResponseDto();
        productDto.setCode(product.getCode());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
