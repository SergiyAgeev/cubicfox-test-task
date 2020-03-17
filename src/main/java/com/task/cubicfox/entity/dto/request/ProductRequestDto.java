package com.task.cubicfox.entity.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.cubicfox.entity.Product;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {
    private Long id;
    private String code;
    private String name;
    private String description;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCode(code);
        product.setDescription(description);
        return product;
    }

    public static ProductRequestDto fromProduct(Product product) {
        ProductRequestDto productRequestDto = new ProductRequestDto();
        productRequestDto.setId(product.getId());
        productRequestDto.setCode(product.getCode());
        productRequestDto.setName(product.getName());
        productRequestDto.setDescription(product.getDescription());
        return productRequestDto;
    }
}
