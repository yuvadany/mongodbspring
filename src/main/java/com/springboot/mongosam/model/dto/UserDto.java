package com.springboot.mongosam.model.dto;


import com.springboot.mongosam.model.Identifiable;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String role;
    private Identifiable company;
}