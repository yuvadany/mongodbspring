package com.springboot.mongosam.controller;

import com.springboot.mongosam.model.dto.UserDto;
import com.springboot.mongosam.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable String id, @RequestBody UserDto dto) {
        dto.setId(id);
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}