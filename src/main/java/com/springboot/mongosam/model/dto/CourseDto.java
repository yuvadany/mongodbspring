package com.springboot.mongosam.model.dto;

import com.springboot.mongosam.model.Identifiable;
import lombok.Data;

@Data
public class CourseDto {
    private String id;
    private String title;
    private String description;
    private Identifiable company;
    private Identifiable instructor;
    
}