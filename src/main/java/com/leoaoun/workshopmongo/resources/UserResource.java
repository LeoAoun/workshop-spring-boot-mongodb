package com.leoaoun.workshopmongo.resources;

import com.leoaoun.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        User user1 = new User("1", "Leonardo Aoun", "leo@gmail.com");
        User user2 = new User("2", "Chester Bennington", "chester@gmail.com");

        //List<User> list = new ArrayList<>();
        //list.addAll(Arrays.asList(leo, bob)

        List<User> list = List.of(user1, user2);

        return ResponseEntity.ok().body(list);
    }
}
