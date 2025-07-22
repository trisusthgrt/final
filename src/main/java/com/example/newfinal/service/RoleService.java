package com.example.newfinal.service;

import com.example.newfinal.entity.Role;
import java.util.List;

public interface RoleService {
    Role getRoleByName(Role.RoleName name);
    List<Role> getAllRoles();
} 