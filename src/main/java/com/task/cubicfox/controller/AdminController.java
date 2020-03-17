package com.task.cubicfox.controller;

import com.task.cubicfox.entity.User;
import com.task.cubicfox.entity.dto.request.AdminUserRequestDto;
import com.task.cubicfox.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public List<AdminUserRequestDto> getAllUsers() {
        return userService.getAll().stream()
                .map(this::getUserResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<AdminUserRequestDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserRequestDto result = AdminUserRequestDto.fromUser(user);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    private AdminUserRequestDto getUserResponseDto(User user) {
        AdminUserRequestDto requestDto = AdminUserRequestDto.fromUser(user);
        return requestDto;
    }
}
