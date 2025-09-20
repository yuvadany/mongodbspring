package com.springboot.mongosam.mapper;

import com.springboot.mongosam.model.Company;
import com.springboot.mongosam.model.dto.CompanyDto;
import org.springframework.stereotype.Component;

/**
     * Manual mapper for Company <-> CompanyDto.
     * Replaces MapStruct mapping to avoid null fields issues.
     */
    @Component
    public class CompanyMapper {

        /**
         * Converts Company entity to CompanyDto.
         * @param company the Company entity
         * @return the mapped CompanyDto
         */
        public CompanyDto toDto(Company company) {
            if (company == null) return null;

            CompanyDto dto = new CompanyDto();
            dto.setId(company.getId());
            dto.setName(company.getName());
            dto.setIndustry(company.getIndustry());
            return dto;
        }

        /**
         * Converts CompanyDto to Company entity.
         * @param dto the CompanyDto
         * @return the mapped Company entity
         */
        public Company toEntity(CompanyDto dto) {
            if (dto == null) return null;

            Company company = new Company();
            company.setId(dto.getId());  // For POST, this can be null (MongoDB will generate it)
            company.setName(dto.getName());
            company.setIndustry(dto.getIndustry());
            return company;
        }
}
