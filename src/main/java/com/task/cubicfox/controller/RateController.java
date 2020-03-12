package com.task.cubicfox.controller;

import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.RateService;
import com.task.cubicfox.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RateController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private RateService rateService;

    @PostMapping
    @RequestMapping("/{productID}")
    public void rateProductById(@PathVariable Long productID,
                                Principal Principal
    ) {

    }
}
