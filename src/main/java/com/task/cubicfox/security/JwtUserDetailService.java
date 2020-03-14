package com.task.cubicfox.security;

import com.task.cubicfox.entity.User;
import com.task.cubicfox.security.jwt.JwtUser;
import com.task.cubicfox.security.jwt.JwtUserFactory;
import com.task.cubicfox.service.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailService implements UserDetailsService {
    private final UserService userService;

    public JwtUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + s + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
