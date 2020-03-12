package com.task.cubicfox.entity.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    @NotEmpty
    private String code;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private Double price;

}
