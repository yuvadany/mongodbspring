package com.springboot.mongosam.model.dto;


import com.springboot.mongosam.model.Identifiable;
import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private Identifiable company;
    private List<Identifiable> courses;
}