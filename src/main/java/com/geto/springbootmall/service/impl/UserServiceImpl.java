package com.geto.springbootmall.service.impl;

import com.geto.springbootmall.dao.UserDao;
import com.geto.springbootmall.dto.UserRegisterRequest;
import com.geto.springbootmall.model.User;
import com.geto.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        //check email exist
        if (user != null) {
            log.warn("This email: \"{}\" had been register", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // create user
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
