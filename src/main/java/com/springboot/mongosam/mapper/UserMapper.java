package com.springboot.mongosam.mapper;

import com.springboot.mongosam.model.Identifiable;
import com.springboot.mongosam.model.User;
import com.springboot.mongosam.model.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserMapper {

    /**
     * Convert User entity to UserDto
     */
    public UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setUsername(user.getUsername());

        // Map company
        dto.setCompany(user.getCompany() != null ? new Identifiable(user.getCompany().getId()) : null);

        return dto;
    }

    /**
     * Convert UserDto to User entity
     */
    public User toEntity(UserDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setUsername(dto.getUsername());

        // Map company
        user.setCompany(dto.getCompany() != null ? new Identifiable(dto.getCompany().getId()) : null);

        return user;
    }
}