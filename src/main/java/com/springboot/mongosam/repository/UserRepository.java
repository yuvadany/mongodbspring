package com.springboot.mongosam.repository;

import com.springboot.mongosam.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }