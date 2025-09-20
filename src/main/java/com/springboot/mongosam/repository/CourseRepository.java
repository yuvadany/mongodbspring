package com.springboot.mongosam.repository;

import com.springboot.mongosam.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> { }
