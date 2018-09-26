package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    public RestResult getUsers();

    //    public RestResult saveUser(String type, String warehouseBy, String location ,String picPath);
    public RestResult addUser();

    public RestResult updateUser(Long userId);

    @Transactional
    public RestResult deleteUser(Long userId);

    public RestResult getUserById(Long userId);
}
