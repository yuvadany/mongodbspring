package com.springboot.mongosam.service;

import com.springboot.mongosam.mapper.UserMapper;
import com.springboot.mongosam.model.User;
import com.springboot.mongosam.model.dto.UserDto;
import com.springboot.mongosam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper ;


    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)   // ✅ works because mapper is injected
                .toList();
    }

    public UserDto save(UserDto dto) {
        User user = mapper.toEntity(dto);          // ✅ instance method
        User saved = repository.save(user);
        return mapper.toDto(saved);                // ✅ instance method
    }
    public UserDto findById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);  // or throw custom exception if preferred
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}