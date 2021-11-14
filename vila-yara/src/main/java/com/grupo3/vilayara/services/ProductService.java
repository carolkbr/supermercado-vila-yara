package com.grupo3.vilayara.services;

import java.util.List;
import java.util.Optional;

import com.grupo3.vilayara.models.Product;

public interface ProductService {
    void saveProduct(Product product);

    Optional<Product> findProductByName(String name);

    List<Product> findAllProducts();

    void updateProduct(Product product);

    void deleteProduct(long id);
}
