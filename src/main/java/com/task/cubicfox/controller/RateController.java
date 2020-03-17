package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.Rate;
import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.RateService;
import com.task.cubicfox.service.UserService;
import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RateController {
    private final ProductService productService;
    private final UserService userService;
    private final RateService rateService;

    public RateController(ProductService productService,
                          UserService userService,
                          RateService rateService) {
        this.productService = productService;
        this.userService = userService;
        this.rateService = rateService;
    }

    @PostMapping
    @RequestMapping("/{productID}")
    public ResponseEntity<String> rateProductById(@PathVariable Long productID,
                                                  @RequestBody Integer rateValue,
                                                  Principal principal
    ) {
        Rate rate = new Rate();
        Product product = productService.getById(productID);
        rate.setRate(rateValue);
        rate.setUser(userService.findByEmail(principal.getName()));
        rate.setProduct(product);
        rateService.save(rate);
        return new ResponseEntity("product: id= " + product.getId() + " "
                + " code = " + product.getCode() + " "
                + " name = " + product.getName()
                + "\nwas rated by: " + principal.getName(), HttpStatus.OK);
    }
}
