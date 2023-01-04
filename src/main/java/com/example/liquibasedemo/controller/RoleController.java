package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.po.Role;
import com.example.liquibasedemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") String id) {
        return roleService.selectByPrimaryKey(id);
    }

    @PostMapping
    public int addRole(@RequestBody Role role) {
        return roleService.insert(role);
    }
}
