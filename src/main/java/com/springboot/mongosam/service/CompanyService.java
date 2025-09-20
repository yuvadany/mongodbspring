package com.springboot.mongosam.service;

import com.springboot.mongosam.mapper.CompanyMapper;
import com.springboot.mongosam.model.Company;
import com.springboot.mongosam.model.dto.CompanyDto;
import com.springboot.mongosam.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyService(CompanyRepository repository, CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Retrieve all companies as DTOs
     */
    public List<CompanyDto> findAll() {
        List<Company> companies = repository.findAll();
        System.out.println("All companies found: " + companies);
        return companies.stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Save or update a company
     */
    public CompanyDto save(CompanyDto dto) {
        System.out.println("Saving CompanyDTO: " + dto);
        Company company = mapper.toEntity(dto);
        Company saved = repository.save(company);
        CompanyDto result = mapper.toDto(saved);
        System.out.println("Saved CompanyDTO: " + result);
        return result;
    }

    /**
     * Find a company by ID
     */
    public CompanyDto findById(String id) {
        Company company = repository.findById(id).orElse(null);
        System.out.println("Company found: " + company);
        CompanyDto dto = mapper.toDto(company);
        System.out.println("Mapped CompanyDTO: " + dto);
        return dto;
    }

    /**
     * Delete a company by ID
     */
    public void deleteById(String id) {
        System.out.println("Deleting company with ID: " + id);
        repository.deleteById(id);
    }
}
