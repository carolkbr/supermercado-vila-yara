package com.grupo3.vilayara.repositories;

import com.grupo3.vilayara.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
