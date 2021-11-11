package com.grupo3.vilayara.repositories;

import com.grupo3.vilayara.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}