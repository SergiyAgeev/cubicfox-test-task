package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.dto.response.ProductResponseDto;
import com.task.cubicfox.service.ProductService;

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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // products?page=~START_PAGE~&limit=~COUNT_VALUES_IN_EACH_PAGE~
    // to filter by code use: /products?code=~YOUR_SEARCHING_CODE~
    @GetMapping
    public List<ProductResponseDto> getAllProducts(@RequestParam(required = false)
                                                           Optional<String> code,
                                                   @RequestParam(required = false)
                                                           Optional<Integer> page,
                                                   @RequestParam
                                                           Optional<Integer> size) {
        Pageable pageRequest = PageRequest.of(page.orElse(0), size.orElse(50));
        return productService.getByCode(code.orElse(""), pageRequest).stream()
                .map(this::getProductResponseDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{productID}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable(name = "productID") Long productID) {

        Product product = productService.getById(productID);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ProductResponseDto result = getProductResponseDto(product);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /*For update, in method body use format like:
    * {
            "code": "000000",
            "name": "00000000000",
            "description": "000000000",
            "status": "NOT_ACTIVE',
            "price": 0.11
        }
    status can be only: ACTIVE, NOT_ACTIVE, DELETED
    */
    @PutMapping
    @RequestMapping("/{productID}")
    public String updateProductById(@RequestBody Product product,
                                    @PathVariable Long productID) {
        productService.update(productID, getProductResponseDto(product));
        return "product with id = " + productID + " updated!";
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
