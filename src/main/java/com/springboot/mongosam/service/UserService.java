package com.springboot.mongosam.service;

import com.springboot.mongosam.mapper.UserMapper;
import com.springboot.mongosam.model.Identifiable;
import com.springboot.mongosam.model.User;
import com.springboot.mongosam.model.dto.UserDto;
import com.springboot.mongosam.repository.CompanyRepository;
import com.springboot.mongosam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final CompanyRepository componyRepository;
    private final UserMapper mapper ;


    public UserService(UserRepository repository,CompanyRepository componyRepository, UserMapper mapper) {
        this.repository = repository;
        this.componyRepository = componyRepository;
        this.mapper = mapper;
    }

    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)   // ✅ works because mapper is injected
                .toList();
    }
    public UserDto save(UserDto dto) {
        System.out.println("Passed Input : " + dto);

        // Convert DTO → Entity
        User user = mapper.toEntity(dto);

        // Only persist the company ID; tag is for response only
        if (dto.getCompany() != null) {
            user.setCompany(new Identifiable(dto.getCompany().getId(),dto.getCompany().getTag()));
        }

        // Save to MongoDB
        User saved = repository.save(user);
        System.out.println("Entity saved : " + saved);

        // Convert Entity → DTO
        UserDto result = mapper.toDto(saved);

        // Enrich the company tag for response
    //    if (result.getCompany() != null) {            result.getCompany().setTag("companies"); // set fixed collection name      }

        System.out.println("Returning DTO : " + result);
        return result;
    }

    public UserDto findById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);  // or throw custom exception if preferred
    }


    public void deleteById(String id) {
        repository.deleteById(id);
    }


    public UserDto update(String id, UserDto dto) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update only fields that are not null
        if (dto.getFirstname() != null) existing.setFirstname(dto.getFirstname());
        if (dto.getLastname() != null) existing.setLastname(dto.getLastname());
        if (dto.getUsername() != null) existing.setUsername(dto.getUsername());
        if (dto.getRole() != null) existing.setRole(dto.getRole());
        if (dto.getCompany() != null) {
            existing.setCompany(new Identifiable(dto.getCompany().getId()));
        }

        User saved = repository.save(existing);

        UserDto result = mapper.toDto(saved);

        // enrich company tag if needed
        if (result.getCompany() != null) {
            componyRepository.findById(result.getCompany().getId())
                    .ifPresent(c -> result.getCompany().setTag("companies"));
        }

        return result;
    }

}