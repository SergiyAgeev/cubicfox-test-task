package com.task.cubicfox.security;

import com.task.cubicfox.entity.User;
import com.task.cubicfox.security.jwt.JwtUser;
import com.task.cubicfox.security.jwt.JwtUserFactory;
import com.task.cubicfox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailService implements UserDetailsService {
    private final UserService userService;

    public JwtUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " not found.");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("loadUserByUsername - user with email = " + email + " successfully loaded.");
        return jwtUser;
    }
}
