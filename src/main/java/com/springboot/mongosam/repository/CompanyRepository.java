package com.springboot.mongosam.repository;

import com.springboot.mongosam.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> { }
