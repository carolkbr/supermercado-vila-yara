package com.grupo3.vilayara.controllers;

import java.util.List;
import java.util.Optional;

import com.grupo3.vilayara.models.Product;
import com.grupo3.vilayara.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api")
public class ProductController {
    
    @Autowired
    ProductRepository productsRepository;

    //salva um produto - create
    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product){
        productsRepository.save(product);
    }

    //lista todos produtos - read all
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productsRepository.findAll();
    }

    //atualiza produto - update
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productsRepository.save(product);
    } 

    //deleta produto por id - delete
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productsRepository.deleteById(id);
    }

    //procura produto por nome
    @GetMapping("/products/{name}")
    public Optional<Product> findProduct(@PathVariable(value = "name") String name){
        return productsRepository.findByName(name);
    }
    
}
