package com.grupo3.vilayara.controllers;

import java.util.List;
import java.util.Optional;

import com.grupo3.vilayara.dtos.ProductDTO;
import com.grupo3.vilayara.models.Product;
import com.grupo3.vilayara.services.ProductService;

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

@RestController()
@RequestMapping(value = "/api")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    // salva um produto - create
    @PostMapping("/products")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDTO dto) {
        try {
            Product product = Product.builder()
                    .name(dto.getName())
                    .productsCategory(dto.getProductsCategory())
                    .description(dto.getDescription())
                    .quantity(dto.getQuantity())
                    .unitaryPrice(dto.getUnitaryPrice())
                    .imageUrl(dto.getImageUrl()).build();
            productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    // procura produto pelo nome
    @GetMapping("/products/{name}")
    public ResponseEntity<Object> findProduct(@PathVariable(value = "name") String name) {
        try {
            Optional<Product> maybeProduct = productService.findProductByName(name);
            if (!maybeProduct.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(maybeProduct.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // lista todos produtos - read all
    @GetMapping("/products")
    public ResponseEntity<Object> findAllProducts() {
        try {
            List<Product> products = productService.findAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // atualiza produto - update
    @PutMapping("/products")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProduct(product);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    //deleta produto
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}