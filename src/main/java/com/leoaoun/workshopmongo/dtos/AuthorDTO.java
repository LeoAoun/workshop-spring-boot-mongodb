package com.leoaoun.workshopmongo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public record AuthorDTO(String id, String name) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
