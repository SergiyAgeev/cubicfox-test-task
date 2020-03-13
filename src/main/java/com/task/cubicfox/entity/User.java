package com.task.cubicfox.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany
    private Set<Role> roles;
}
