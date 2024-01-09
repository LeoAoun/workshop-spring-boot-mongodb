package com.leoaoun.workshopmongo.dtos;

import com.leoaoun.workshopmongo.domain.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record UserDTO(String name, String email) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



}
