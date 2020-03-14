package com.task.cubicfox.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

    final private Long id;
    final private String name;
    final private String email;
    final private String password;
    final private Boolean enable;
    final private LocalDateTime created;
    final private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id,
                   String name,
                   String email,
                   String password,
                   Boolean enable,
                   LocalDateTime created,
                   Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.created = created;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getEnable() {
        return enable;
    }

    @JsonIgnore
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
