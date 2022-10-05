package com.geto.springbootmall.service.impl;

import com.geto.springbootmall.dao.UserDao;
import com.geto.springbootmall.dto.UserRegisterRequest;
import com.geto.springbootmall.model.User;
import com.geto.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
