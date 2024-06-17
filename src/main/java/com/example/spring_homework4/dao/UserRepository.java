package com.example.spring_homework4.dao;

import com.example.spring_homework4.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUsersByUserName(String userName);

}
