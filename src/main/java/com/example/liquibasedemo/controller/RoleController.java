package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.po.Role;
import com.example.liquibasedemo.request.BasePageRequest;
import com.example.liquibasedemo.service.RoleService;
import com.example.liquibasedemo.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="test")
@RequestMapping("/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") String id) {
        return roleService.selectByPrimaryKey(id);
    }


    @GetMapping("/page")
    public PageInfo<RoleVo> getRoles(@RequestBody BasePageRequest request) {
        return roleService.list(request);
    }

    @PostMapping
    public int addRole(@RequestBody Role role) {
        return roleService.insert(role);
    }
}
