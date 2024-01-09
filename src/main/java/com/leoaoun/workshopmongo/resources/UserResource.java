package com.leoaoun.workshopmongo.resources;

import com.leoaoun.workshopmongo.domain.User;
import com.leoaoun.workshopmongo.dtos.UserDTO;
import com.leoaoun.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
