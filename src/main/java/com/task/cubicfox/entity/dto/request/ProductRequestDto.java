package com.task.cubicfox.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String code;
    private String name;
    private String description;
    private Double price;

}
