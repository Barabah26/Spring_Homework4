package com.example.spring_homework4.mapper.user;

import com.example.spring_homework4.domain.User;
import com.example.spring_homework4.dto.user.UserDto;
import com.example.spring_homework4.mapper.DtoMapperFacade;
import com.example.spring_homework4.util.JwtUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDtoMapper extends DtoMapperFacade<User, UserDto> {

    public UserDtoMapper() {
        super(User.class, UserDto.class);
    }

    @Override
    protected void decorateDto(UserDto dto, User user) {
        dto.setUserName(user.getUserName());
        dto.setSysRoles(String.valueOf(user.getRoles()));
    }
}
