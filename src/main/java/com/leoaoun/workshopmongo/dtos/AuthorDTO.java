package com.leoaoun.workshopmongo.dtos;

import com.leoaoun.workshopmongo.domain.User;

import java.io.Serial;
import java.io.Serializable;

public record AuthorDTO(String id, String name) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
