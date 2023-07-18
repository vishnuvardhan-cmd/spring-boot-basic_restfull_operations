package com.dailycodelearner.springboot.v2.entity;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
}
