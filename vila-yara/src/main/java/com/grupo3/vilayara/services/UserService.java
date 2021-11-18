package com.grupo3.vilayara.services;

import java.util.List;

import com.grupo3.vilayara.models.User;


public interface UserService {
 
    void saveUser(User user);

    List<User> findAllUsers();

    void updateUser(User user);

    void deleteById(long id);
    
}
