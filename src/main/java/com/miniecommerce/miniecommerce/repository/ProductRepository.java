package com.miniecommerce.miniecommerce.repository;

import com.miniecommerce.miniecommerce.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
