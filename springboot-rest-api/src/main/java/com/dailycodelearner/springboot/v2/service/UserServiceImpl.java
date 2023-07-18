package com.dailycodelearner.springboot.v2.service;

import com.dailycodelearner.springboot.v2.Mapper.MapperConversion;
import com.dailycodelearner.springboot.v2.entity.User;
import com.dailycodelearner.springboot.v2.entity.UserDto;
import com.dailycodelearner.springboot.v2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=MapperConversion.userDtoToUser(userDto);
        User user1=userRepository.save(user);
        UserDto userDto1=MapperConversion.userToUserDto(user1);
        return userDto1;
    }

    @Override
    public UserDto getByUserId(int id) {
        User user=userRepository.findById(id).get();
        return MapperConversion.userToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        return MapperConversion.userToUserDtoList(userRepository.findAll());

    }

    @Override
    public UserDto updateUser(UserDto user) {
        User exsistingUser=userRepository.findById(user.getId()).get();
        exsistingUser.setFirstName(user.getFirstName());
        exsistingUser.setLastName(user.getLastName());
        exsistingUser.setEmailId(user.getEmailId());
        User user1=userRepository.save(exsistingUser);
        UserDto userDto1=MapperConversion.userToUserDto(user1);
        return userDto1;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
