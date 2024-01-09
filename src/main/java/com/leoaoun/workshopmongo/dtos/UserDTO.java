package com.leoaoun.workshopmongo.dtos;

import java.io.Serial;
import java.io.Serializable;

public record UserDTO(String name, String email) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
