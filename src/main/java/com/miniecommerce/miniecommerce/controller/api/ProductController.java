package com.miniecommerce.miniecommerce.controller.api;

import java.util.List;

import com.miniecommerce.miniecommerce.domain.Product;
import com.miniecommerce.miniecommerce.repository.ProductRepository;
import com.miniecommerce.miniecommerce.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    ProductRepository productRepository;
    UserRepository userRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Product> find() {
        return productRepository.findAll();
    }
}
