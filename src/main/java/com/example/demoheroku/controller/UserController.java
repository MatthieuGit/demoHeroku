package com.example.demoheroku.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

import com.example.demoheroku.entities.User;
import com.example.demoheroku.entities.repository.UserRepository;
import com.example.demoheroku.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String getWelcome() {
        return "Bienvenue chez moi";
    }

    @GetMapping
    public List<User> getAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }
    @PostMapping
    public User addUser(@Valid @RequestBody User user)
    {
        return userRepository.save(user);

    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Integer idUser)
    {
        return userRepository.findById(idUser).orElseThrow(()->new ResourceNotFoundException("user", "id", idUser));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value="id") Integer idUser)
    {
        User user = userRepository.findById(idUser).orElseThrow(()->new ResourceNotFoundException("user", "id", idUser));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
