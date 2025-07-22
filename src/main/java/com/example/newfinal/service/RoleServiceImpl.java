package com.example.newfinal.service;

import com.example.newfinal.entity.Role;
import com.example.newfinal.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Role getRoleByName(Role.RoleName name) {
        return roleRepository.findByName(name).orElseThrow();
    }
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
} 