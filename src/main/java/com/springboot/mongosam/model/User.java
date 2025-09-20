package com.springboot.mongosam.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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



}