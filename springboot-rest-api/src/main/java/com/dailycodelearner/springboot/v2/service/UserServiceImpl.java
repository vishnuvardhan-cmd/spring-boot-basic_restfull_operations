package com.dailycodelearner.springboot.v2.service;

import com.dailycodelearner.springboot.v2.entity.User;
import com.dailycodelearner.springboot.v2.exception.UserNotFoundException;
import com.dailycodelearner.springboot.v2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByUserId(int id) {
//        userRepository.findById(id).get().orElseThrow(new UserNotFoundException());
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user","id",id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exsistingUser=userRepository.findById(user.getId()).get();
        exsistingUser.setFirstName(user.getFirstName());
        exsistingUser.setLastName(user.getLastName());
        exsistingUser.setEmailId(user.getEmailId());
        return userRepository.save(exsistingUser);
    }

    @Override
    public void deleteById(int id) {
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user","id",id));
        userRepository.deleteById(id);
    }
}
