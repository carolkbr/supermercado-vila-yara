package com.grupo3.vilayara.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import com.grupo3.vilayara.models.User;
import com.grupo3.vilayara.repositories.UserRepository;
import com.grupo3.vilayara.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementartion implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
