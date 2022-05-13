package com.miniecommerce.miniecommerce.controller.api;

import java.util.List;

import com.miniecommerce.miniecommerce.domain.Product;
import com.miniecommerce.miniecommerce.domain.User;
import com.miniecommerce.miniecommerce.exceptions.NotFoundException;
import com.miniecommerce.miniecommerce.repository.ProductRepository;
import com.miniecommerce.miniecommerce.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    UserRepository userRepository;
    ProductRepository productRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public User getUserByEmail(@RequestParam String email, @RequestParam String password) {
        // TODO: DO PASSWORD SAVE WITH JWT 
        User user = userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public User add(@RequestBody UserDTO user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    @PostMapping("/add-user-favorite")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addFavorite(@RequestBody FavoriteDTO favoriteDto) {
        User user = userRepository.findById(favoriteDto.getUserId()).orElseThrow(NotFoundException::new);
        Product product = productRepository.findById(favoriteDto.getProductId()).orElseThrow(NotFoundException::new);
        user.getFavorites().add(product);

        userRepository.save(user);
    }

    @GetMapping("/get-favorites")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Product> getUserFavorites(@RequestParam String userId) throws NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return user.getFavorites();
    }

    @DeleteMapping("/remove-favorite")
    @CrossOrigin(origins = "http://localhost:3000")
    public void removeFavorite(@RequestBody FavoriteDTO favoriteDto) throws NotFoundException {
        User user = userRepository.findById(favoriteDto.getUserId()).orElseThrow(NotFoundException::new);
        Product product = productRepository.findById(favoriteDto.getProductId()).orElseThrow(NotFoundException::new);

        user.getFavorites().remove(product);
        userRepository.save(user);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class FavoriteDTO {
        private String userId;
        private String productId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class UserDTO {
        private String name;

        private String email;

        private String password;
    }
}

