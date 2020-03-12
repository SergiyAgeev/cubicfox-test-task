package com.task.cubicfox.entity.dto.response;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    @NotEmpty
    private String code;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private Double price;
}
