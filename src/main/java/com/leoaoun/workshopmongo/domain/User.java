package com.leoaoun.workshopmongo.domain;

import com.leoaoun.workshopmongo.dtos.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }

    public User(Object o, String name, String email) {
        this.name = name;
        this.email = email;
    }
}
