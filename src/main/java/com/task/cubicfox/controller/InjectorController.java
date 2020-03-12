package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.User;
import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.UserService;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectorController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public void test() {
        User user = new User();
        user.setName("Serhii");
        user.setEmail("sergiyageev@gmail.com");
        user.setPassword("1234");
        userService.save(user);

        IntStream.range(0, 200).forEach(i -> {
            User user1 = new User();
            user1.setName("userName" + i);
            user1.setEmail("email" + i + "@mail.com");
            user1.setPassword(i + "" + i + 1);
            userService.save(user1);
        });

        for (int i = 0; i < 1000; i++) {
            Product product = new Product();
            product.setCode(String.valueOf(codeGenerator().toArray()[i]));
            product.setName("ProductName" + i);
            product.setDescription("Big description" + i);
            product.setPrice(i + 0.1);
            productService.add(product);
        }
    }

    private Set<String> codeGenerator() {
        Set<String> strings = new HashSet<>();
        while (strings.size() != 1000) {
            for (int i = 0; i < 1000; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < 6; j++) {
                    int randomNumberCounter = new Random()
                            .ints(0, 10)
                            .findFirst()
                            .getAsInt();
                    stringBuilder.append(randomNumberCounter);
                }
                strings.add(stringBuilder.toString());
            }
        }
        return strings;
    }
}