package com.task.cubicfox.controller;

import com.task.cubicfox.entity.Product;
import com.task.cubicfox.entity.Role;
import com.task.cubicfox.entity.Status;
import com.task.cubicfox.entity.User;
import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.RoleService;
import com.task.cubicfox.service.UserService;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final UserService userService;
    private final ProductService productService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    Object[] stringSet = codeGenerator().toArray();

    public InjectController(UserService userService,
                            ProductService productService,
                            RoleService roleService,
                            BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.productService = productService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void postConstruct() {
        Role userRole = new Role();
        userRole.setName("USER");
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleService.add(userRole);
        roleService.add(adminRole);

        User user = new User();
        user.setName("Serhii");
        user.setEmail("sergiyageev@gmail.com");
        user.setPassword("1234");
        user.addRole(roleService.getRole("ADMIN"));
        userService.save(user);
    }

    @GetMapping
    public ResponseEntity<String> injectData() {
        IntStream.range(0, 20).forEach(i -> {
            User user1 = new User();
            user1.setName("userName" + i);
            user1.setEmail("email" + i + "@mail.com");
            user1.setPassword("1234");
            userService.save(user1);
        });

        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setCode(String.valueOf(stringSet[i]));
            product.setName("ProductName" + i);
            product.setDescription("Big description" + i);
            product.setPrice(i + 0.1);
            product.setStatus(Status.ACTIVE);
            productService.save(product);
        }
        return ResponseEntity.ok("Success! Data injected!");
    }

    private Set<String> codeGenerator() {
        Set<String> strings = new HashSet<>();
        while (strings.size() != 500) {
            IntStream.range(0, 500).mapToObj(i -> IntStream.range(0, 6).map(j -> new Random()
                    .ints(0, 10)
                    .findFirst()
                    .getAsInt())
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining()))
                    .forEach(strings::add);
        }
        return strings;
    }
}
