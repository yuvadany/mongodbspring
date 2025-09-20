package com.springboot.mongosam.controller;

import com.springboot.mongosam.model.dto.CourseDto;
import com.springboot.mongosam.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public CourseDto create(@RequestBody CourseDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable String id, @RequestBody CourseDto dto) {
        dto.setId(id);
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
