package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Role;
import com.task.cubicfox.entity.Status;
import com.task.cubicfox.entity.User;
import com.task.cubicfox.repository.RoleRepository;
import com.task.cubicfox.repository.UserRepository;
import com.task.cubicfox.service.UserService;

import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user) {
        Role roleUser = roleRepository.findByName("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(roleUser);
        user.setStatus(Status.ACTIVE);
        user.setCreateDate(new Date());

        userRepository.save(user);
        log.info("User with id = " + user.getId() + " was successfully registered");
    }

    @Override
    public List<User> getAll() {
        List<User> all = userRepository.findAll();
        log.info("All users found");
        return all;

    }

    @Override
    public User getUserById(Long id) {
        User one = userRepository.findById(id).orElse(null);
        if (one == null) {
            log.warn("Can`t find user with id = " + id);
        }
        log.info("User was found with id = " + id);
        return one;
    }

    @Override
    public User findByEmail(String email) {
        User byEmail = userRepository.findByEmail(email);
        log.info("User was found by email = " + email);
        return byEmail;
    }

    @Override
    public void delete(Long id) {
        log.info("User was deleted with id = " + id);
        userRepository.deleteById(id);
    }
}
