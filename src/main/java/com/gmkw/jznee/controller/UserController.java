package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = {RequestMethod.POST})
    public RestResult getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public RestResult addUser(){
        return userService.addUser();
    }

    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST})
    public RestResult updateUser(@RequestParam(value = "userId") Long userId){
        return userService.updateUser(userId);
    }

    @RequestMapping(value = "/delUser", method = {RequestMethod.POST})
    public RestResult delUser(@RequestParam(value = "userId") Long userId){
        return userService.deleteUser(userId);
    }

    @RequestMapping(value = "/getUserById", method = {RequestMethod.POST})
    public RestResult getUserById(@RequestParam(value = "userId") Long userId){
        return userService.getUserById(userId);
    }

}
