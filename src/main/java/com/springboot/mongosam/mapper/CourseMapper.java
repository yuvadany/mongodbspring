package com.springboot.mongosam.mapper;

import com.springboot.mongosam.model.Course;
import com.springboot.mongosam.model.dto.CourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course) {
        if (course == null) return null;

        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        return dto;
    }

    /**
     * Convert CourseDto to entity
     */
    public Course toEntity(CourseDto dto) {
        if (dto == null) return null;

        Course course = new Course();
        course.setId(dto.getId()); // null if new entity
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        return course;
    }
}
