package com.example.liquibasedemo.service;

import com.example.liquibasedemo.mapper.UserMapper;
import com.example.liquibasedemo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(String id) {
        return userMapper.getUserById(id);
    }

    public boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }
}
