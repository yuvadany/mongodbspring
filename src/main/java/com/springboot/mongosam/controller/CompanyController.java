package com.springboot.mongosam.controller;

import com.springboot.mongosam.model.dto.CompanyDto;
import com.springboot.mongosam.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public List<CompanyDto> getAll() {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public CompanyDto getById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public CompanyDto create(@RequestBody CompanyDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public CompanyDto update(@PathVariable("id")  String id, @RequestBody CompanyDto dto) {
        dto.setId(id);
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.deleteById(id);
    }
}