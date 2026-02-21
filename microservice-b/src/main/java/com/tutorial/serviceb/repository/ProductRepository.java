package com.tutorial.serviceb.repository;

import com.tutorial.serviceb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
