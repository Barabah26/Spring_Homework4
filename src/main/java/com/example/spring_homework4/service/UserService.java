package com.example.spring_homework4.service;

import com.example.spring_homework4.domain.User;
import com.example.spring_homework4.dao.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getByLogin(@NonNull String login) {
        return userRepository.findUsersByUserName(login);
    }

}