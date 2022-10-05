package com.geto.springbootmall.dao;

import com.geto.springbootmall.dto.UserLoginRequest;
import com.geto.springbootmall.dto.UserRegisterRequest;
import com.geto.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
