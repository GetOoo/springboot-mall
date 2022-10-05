package com.geto.springbootmall.service;

import com.geto.springbootmall.dto.UserLoginRequest;
import com.geto.springbootmall.dto.UserRegisterRequest;
import com.geto.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
