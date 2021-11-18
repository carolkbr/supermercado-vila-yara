package com.grupo3.vilayara.controllers;

import java.util.ArrayList;
import java.util.List;

import com.grupo3.vilayara.dtos.ListUserDTO;
import com.grupo3.vilayara.dtos.UserDTO;
import com.grupo3.vilayara.models.User;
import com.grupo3.vilayara.services.UserService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private UserService userService;

    public UserController(UserService service){
        this.userService = service;
    }

    // salva um usuario - create
    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO dto){
       try{
            User user = User.builder().userName(dto.getUserName()).name(dto.getName())
                        .email(dto.getEmail()).password(dto.getPassword())
                        .creationDate(dto.getCreationDate())
                        .type(dto.getType()).build();
                        userService.saveUser(user);
                        return ResponseEntity.status(HttpStatus.CREATED).build();
       }catch(Exception e){
            return ResponseEntity.internalServerError().build(); 
       }
    }

    // lista todos usuarios - read all
    @GetMapping("/users")
    public ResponseEntity<Object> findAllUsers() {
        try {
            List<User> users = userService.findAllUsers();
            List<ListUserDTO> usersDTO = foo(users);
            return ResponseEntity.ok(usersDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // atualiza usuario - update
    @PutMapping("/users")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // deleta usuario por nome de usuario
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") long id){
        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    private List<ListUserDTO> foo(List<User> users){
        List<ListUserDTO> listDTO = new ArrayList<ListUserDTO>();
        
        for(int i = 0; i < users.size(); i++){
         User user = users.get(i);
         listDTO.add(ListUserDTO.builder().id(user.getId()).userName(user.getUserName()).creationDate(user.getCreationDate()).build());
        }
        return listDTO;
    }
}
