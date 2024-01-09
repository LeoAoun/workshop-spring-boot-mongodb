package com.leoaoun.workshopmongo.resources;

import com.leoaoun.workshopmongo.domain.User;
import com.leoaoun.workshopmongo.dtos.UserDTO;
import com.leoaoun.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x.getName(), x.getEmail())).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user.getName(), user.getEmail());
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO){
        User user = userService.insert(new User(userDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
