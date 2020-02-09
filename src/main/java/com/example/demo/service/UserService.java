package com.example.demo.service;

import com.example.demo.model.UserVO;

import java.util.List;

public interface UserService {

    UserVO saveUser(UserVO user);

    int deleteUser(int id);

    int updateUser(UserVO user);

    UserVO getUser(int id);

    List<UserVO> getAll();
}
