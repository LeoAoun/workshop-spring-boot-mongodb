package com.leoaoun.workshopmongo.services;

import com.leoaoun.workshopmongo.domain.Post;
import com.leoaoun.workshopmongo.repositories.PostRepository;
import com.leoaoun.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Post post = repository.findById(id).orElse(null);

        if (post == null) {
            throw new ObjectNotFoundException("Post not found");
        }

        return post;
    }


}
