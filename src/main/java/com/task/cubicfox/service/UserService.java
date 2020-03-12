package com.task.cubicfox.service;

import com.task.cubicfox.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> getAll();

    User getUserById(Long id);
}
