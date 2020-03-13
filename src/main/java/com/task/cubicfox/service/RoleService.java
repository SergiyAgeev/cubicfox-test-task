package com.task.cubicfox.service;

import com.task.cubicfox.entity.Role;

public interface RoleService {
    Role add(Role role);

    Role getRole(String role);
}
