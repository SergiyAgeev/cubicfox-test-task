package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.dto.request.ProductRequestDto;
import com.task.cubicfox.entity.dto.response.ProductResponseDto;
import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.RateService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final RateService rateService;

    public ProductController(ProductService productService, RateService rateService) {
        this.productService = productService;
        this.rateService = rateService;
    }

    @GetMapping
    public List<ProductRequestDto> getAllProducts(@RequestParam(required = false)
                                                          Optional<String> code,
                                                  @RequestParam(required = false)
                                                          Optional<Integer> page,
                                                  @RequestParam
                                                          Optional<Integer> size) {
        Pageable pageRequest = PageRequest.of(page.orElse(0), size.orElse(20));
        return productService.getByCode(code.orElse(""), pageRequest).stream()
                .map(this::getProductRequestDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{productID}", method = RequestMethod.GET)
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable(name = "productID") Long productID) {

        Product product = productService.getSingleProduct(productID);
        ProductResponseDto productResponseDto = getProductResponseDto(product);
        productResponseDto.setRate(rateService.getRateByProductId(product.getId()) == null
                ? Double.valueOf(0.0) : rateService.getRateByProductId(product.getId()));

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(productResponseDto, HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/{productID}")
    public ResponseEntity<String> updateProductById(@RequestBody Product product,
                                                    @PathVariable Long productID) {
        productService.update(productID, product);
        return new ResponseEntity<>("product with id = " + productID + " updated!",
                HttpStatus.OK);
    }

    private ProductResponseDto getProductResponseDto(Product product) {
        ProductResponseDto productDto = ProductResponseDto.fromProduct(product);
        return productDto;
    }

    private ProductRequestDto getProductRequestDto(Product product) {
        ProductRequestDto productDto = ProductRequestDto.fromProduct(product);
        return productDto;
    }
}
