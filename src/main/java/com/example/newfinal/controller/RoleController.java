package com.example.newfinal.controller;

import com.example.newfinal.entity.Role;
import com.example.newfinal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{name}")
    public Role getRoleByName(@PathVariable Role.RoleName name) {
        return roleService.getRoleByName(name);
    }
} 