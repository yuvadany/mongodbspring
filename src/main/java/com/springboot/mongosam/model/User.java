package com.springboot.mongosam.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * User entity for MongoDB
 */
@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String firstname;
    private String lastname;
    private String username;

    /**
     * Reference to a company (only stores the ID)
     */
    private Identifiable company;

    /**
     * List of course references (only IDs)
     */
    private List<Identifiable> courses;

}