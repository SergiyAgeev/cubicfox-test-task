package com.task.cubicfox.controller;

import com.task.cubicfox.entity.User;
import com.task.cubicfox.repository.UserRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @GetMapping
    @RequestMapping("/injectuser")
    public void test() {
        User user = new User();
        user.setName("Vasia");
        user.setEmail("123");
        userRepository.save(user);

    }

}
