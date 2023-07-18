package com.dailycodelearner.springboot.v2.controller;

import com.dailycodelearner.springboot.v2.entity.User;
import com.dailycodelearner.springboot.v2.entity.UserDto;
import com.dailycodelearner.springboot.v2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;

import java.util.List;

@RestController
@RequestMapping("/v2")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userObj = userService.createUser(userDto);
        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getByUserId(@PathVariable("id") int id){
        UserDto user=userService.getByUserId(id);
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }
    
    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }

    @PutMapping("/user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        UserDto user1=userService.updateUser(userDto);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
}
