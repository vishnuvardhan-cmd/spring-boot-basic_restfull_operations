package com.dailycodelearner.springboot.v2.Mapper;

import com.dailycodelearner.springboot.v2.entity.User;
import com.dailycodelearner.springboot.v2.entity.UserDto;

import java.util.ArrayList;
import java.util.List;

public class MapperConversion {

    public static UserDto userToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmailId(user.getEmailId());
        return userDto;
    }

    public static User userDtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailId(userDto.getEmailId());
        return user;
    }

    public static List<UserDto> userToUserDtoList(List<User> users){
        List<UserDto> list=new ArrayList<>();
        for(User user:users) {
            UserDto userDto=new UserDto();
            userDto.setId(user.getId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setEmailId(user.getEmailId());
            list.add(userDto);
        }
        return list;
    }
}
