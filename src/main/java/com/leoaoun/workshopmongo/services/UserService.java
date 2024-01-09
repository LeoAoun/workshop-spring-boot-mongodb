package com.leoaoun.workshopmongo.services;

import com.leoaoun.workshopmongo.domain.User;
import com.leoaoun.workshopmongo.dtos.UserDTO;
import com.leoaoun.workshopmongo.repositories.UserRepository;
import com.leoaoun.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElse(null);

        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        return user;
    }

    public User insert(User user) {
        return repository.insert(user);
    }

}
