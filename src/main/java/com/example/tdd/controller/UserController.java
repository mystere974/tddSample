package com.example.tdd.controller;

import com.example.tdd.model.UsersEntity;
import com.example.tdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService clientService) {
        this.userService = clientService;
    }

    @PostMapping
    public UsersEntity addClient(@RequestBody UsersEntity user) throws Exception {
        return userService.addUser(user);
    }

    @GetMapping
    public List<UsersEntity> getAllClients() throws Exception {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersEntity getClientById(@PathVariable int id) throws Exception {
        return userService.getUserById(id);
    }
}
