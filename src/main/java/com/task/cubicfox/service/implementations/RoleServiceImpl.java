package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Role;
import com.task.cubicfox.repository.RoleRepository;
import com.task.cubicfox.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        Role save = roleRepository.save(role);
        log.info("role = " + role.getName() + " was successfully added.");
        return save;
    }

    @Override
    public Role getRole(String role)  {
        Role byName = roleRepository.findByName(role);
        log.info("get role with name = " + role + " was successfully get.");
        return byName;
    }
}
