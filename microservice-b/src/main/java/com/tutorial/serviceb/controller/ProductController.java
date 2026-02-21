package com.tutorial.serviceb.controller;

import com.tutorial.serviceb.model.Product;
import com.tutorial.serviceb.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieve a specific product by its ID")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Create a new product with name and price")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
