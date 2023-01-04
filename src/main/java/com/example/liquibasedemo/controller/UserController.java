package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.po.User;
import com.example.liquibasedemo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation(value = "Get User")
    @ApiImplicitParam(name = "id", value = "用户 Id", defaultValue = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = -1, message = "Failure")
    })
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }


    @PostMapping()
    public boolean addUser(@RequestBody User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        long timestamp = System.currentTimeMillis();
        user.setCreatedAt(timestamp);
        user.setLastUpdatedAt(timestamp);
        return userService.addUser(user);
    }
}
