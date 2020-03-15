package com.task.cubicfox.controller;

import com.task.cubicfox.entity.User;
import com.task.cubicfox.entity.dto.request.UserRequestDto;
import com.task.cubicfox.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<UserRequestDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserRequestDto result = UserRequestDto.fromUser(user);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
