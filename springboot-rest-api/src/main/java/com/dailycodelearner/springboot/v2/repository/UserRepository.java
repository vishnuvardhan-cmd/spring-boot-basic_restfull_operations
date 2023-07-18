package com.dailycodelearner.springboot.v2.repository;

import com.dailycodelearner.springboot.v2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
