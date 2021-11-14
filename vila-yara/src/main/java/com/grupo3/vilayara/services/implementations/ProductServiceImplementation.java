package com.grupo3.vilayara.services.implementations;

import java.util.List;
import java.util.Optional;

import com.grupo3.vilayara.models.Product;
import com.grupo3.vilayara.repositories.ProductRepository;
import com.grupo3.vilayara.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    ProductRepository productsRepository;

    @Override
    public void saveProduct(Product product) {
        productsRepository.save(product);   
    }

    @Override
    public Optional<Product> findProductByName(String name){
       return productsRepository.findByName(name);
    }

    @Override
    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) {
        productsRepository.save(product);       
    }

    @Override
    public void deleteProduct(long id) {
      productsRepository.deleteById(id);  
    }
}
