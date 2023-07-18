package com.dailycodelearner.springboot.v3.bean;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
