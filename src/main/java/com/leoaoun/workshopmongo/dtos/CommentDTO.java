package com.leoaoun.workshopmongo.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record CommentDTO (String text, Date date, AuthorDTO author) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

}
