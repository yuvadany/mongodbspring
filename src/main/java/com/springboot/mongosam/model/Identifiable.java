package com.springboot.mongosam.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Identifiable {
    @Id
    private String id;
    private String tag;

    public Identifiable(String id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public Identifiable(String id) {
        this.id = id;
    }
}