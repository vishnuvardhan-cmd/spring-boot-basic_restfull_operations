package com.dailycodelearner.springboot.v2.service;

import com.dailycodelearner.springboot.v2.entity.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getByUserId(int id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteById(int id);
}
