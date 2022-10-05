package com.geto.springbootmall.service.impl;

import com.geto.springbootmall.dao.UserDao;
import com.geto.springbootmall.dto.UserLoginRequest;
import com.geto.springbootmall.dto.UserRegisterRequest;
import com.geto.springbootmall.model.User;
import com.geto.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //check email exist
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user != null) {
            log.warn("This email: \"{}\" had been register", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // create user + Hash
        String hashpwd = DigestUtils.md5DigestAsHex((userRegisterRequest.getPassword() + "salt").getBytes());
        userRegisterRequest.setPassword(hashpwd);
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        //check email exist
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        if (user == null) {
            log.warn("This email: \"{}\" not exist", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // check pwd
        String hashpwd = DigestUtils.md5DigestAsHex((userLoginRequest.getPassword() + "salt").getBytes());
        userLoginRequest.setPassword(hashpwd);
        if (user.getPassword().equals(userLoginRequest.getPassword())) {
            return user;
        } else {
            log.warn("賬號或密碼不正確");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
