package com.leoaoun.workshopmongo.resources;

import com.leoaoun.workshopmongo.domain.Post;
import com.leoaoun.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping()
    public ResponseEntity<List<Post>> findAll(){
        List<Post> post = postService.findAll();
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }



}
