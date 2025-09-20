package com.springboot.mongosam.service;

import com.springboot.mongosam.mapper.CourseMapper;
import com.springboot.mongosam.model.Course;
import com.springboot.mongosam.model.dto.CourseDto;
import com.springboot.mongosam.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CourseDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public CourseDto save(CourseDto dto) {
        Course course = mapper.toEntity(dto);
        Course saved = repository.save(course);
        return mapper.toDto(saved);
    }

    public CourseDto findById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}