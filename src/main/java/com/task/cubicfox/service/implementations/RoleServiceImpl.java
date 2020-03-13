package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Role;
import com.task.cubicfox.repository.RoleRepository;
import com.task.cubicfox.service.RoleService;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(String role) {
        return roleRepository.findByName(role);
    }
}
