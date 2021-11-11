package com.grupo3.vilayara.controllers;

import java.util.List;

import com.grupo3.vilayara.models.User;
import com.grupo3.vilayara.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // salva um usuario - create
    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }

    // lista todos usuarios - read all
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // atualiza usuario - update
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // deleta usuario por id - delete
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userRepository.deleteById(id);
    }
}
