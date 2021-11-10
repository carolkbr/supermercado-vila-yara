package com.grupo3.vilayara.repositories;

import java.util.Optional;

import com.grupo3.vilayara.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findByName(String name);
}
