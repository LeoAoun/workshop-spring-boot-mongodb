package com.leoaoun.workshopmongo.domain;

import com.leoaoun.workshopmongo.dtos.AuthorDTO;
import com.leoaoun.workshopmongo.dtos.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public Post (Object o, Date date, String title, String body, AuthorDTO author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
