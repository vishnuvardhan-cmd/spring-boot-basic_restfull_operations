package com.dailycodelearner.springboot.v2.service;

import com.dailycodelearner.springboot.v2.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getByUserId(int id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteById(int id);
}
