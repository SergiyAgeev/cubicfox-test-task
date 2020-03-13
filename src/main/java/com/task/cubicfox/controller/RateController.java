package com.task.cubicfox.controller;

import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.RateService;
import com.task.cubicfox.service.UserService;

import java.security.Principal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RateController {
    private final ProductService productService;
    private final UserService userService;
    private final RateService rateService;

    public RateController(ProductService productService, UserService userService, RateService rateService) {
        this.productService = productService;
        this.userService = userService;
        this.rateService = rateService;
    }

    @PostMapping
    @RequestMapping("/{productID}")
    public void rateProductById(@PathVariable Long productID,
                                Principal Principal
    ) {

    }
}
