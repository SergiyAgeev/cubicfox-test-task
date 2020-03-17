package com.task.cubicfox.service;

import com.task.cubicfox.entity.User;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface UserService {

    void save(User user) throws DataAccessException;

    List<User> getAll();

    User getUserById(Long id);

    User findByEmail(String email);
}
