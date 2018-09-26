package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.User;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.UserReadRepository;
import com.gmkw.jznee.repository.write.UserWriteRepository;
import com.gmkw.jznee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReadRepository userReadRepository;

    @Autowired
    private UserWriteRepository userWriteRepository;


    @Override
    @Cacheable(key = "'users'")
    public RestResult getUsers() {
        return new RestResult(Constants.STATE_SUCCESS, "",userReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'users'")
//    public RestResult saveUser(String type, String warehouseBy, String location, String picPath) {
    public RestResult addUser() {
        User user = new User();

        user.setCreateBy("createby");
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setName("name11");
        user.setPassword("passwaord11");
        user.setRole(1);
        user.setStatus(00001L);
        user.setUpdateBy("updateBy");
        user.setUpdateTime(new Timestamp(new Date().getTime()));

        userWriteRepository.save(user);
        return new RestResult(Constants.STATE_SUCCESS, "",user);
    }

    @Override
    @CachePut(key = "'user_' +  #userId")
    @CacheEvict(key = "'users'")
    public RestResult updateUser(Long userId) {
        User user = userReadRepository.findUserById(userId);


        user.setCreateBy("createby");
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setName("name2");
        user.setPassword("passwaord2");
        user.setRole(2);
        user.setStatus(00002L);
        user.setUpdateBy("updateBy");
        user.setUpdateTime(new Timestamp(new Date().getTime()));

        userWriteRepository.save(user);
        return new RestResult(Constants.STATE_SUCCESS, "",user);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'users'"), @CacheEvict(key = "'user_' +  #userId") })
    public RestResult deleteUser(Long userId) {
        userWriteRepository.deleteUserById(userId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'user_' +  #userId")
    public RestResult getUserById(Long userId) {
        return new RestResult(Constants.STATE_SUCCESS, "",userReadRepository.findUserById(userId));
    }
}
