package com.example.liquibasedemo.service;

import com.example.liquibasedemo.mapper.RoleMapper;
import com.example.liquibasedemo.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
