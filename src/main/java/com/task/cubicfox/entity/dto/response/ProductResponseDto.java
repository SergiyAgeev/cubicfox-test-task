package com.task.cubicfox.entity.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.Status;
import java.util.Date;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDto {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private Status status;
    private Date createDate;
    private Double rate;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStatus(status);
        product.setCreateDate(createDate);
        return product;
    }

    public static ProductResponseDto fromProduct(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setCode(product.getCode());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStatus(product.getStatus());
        productResponseDto.setCreateDate(product.getCreateDate());
        return productResponseDto;
    }
}
