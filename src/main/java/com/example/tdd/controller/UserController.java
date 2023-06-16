package com.example.tdd.controller;


import com.example.tdd.model.UsersEntity;
import com.example.tdd.repository.UsersRepository;
import com.example.tdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/save")
    public ResponseEntity<Object> addUser(@RequestBody UsersEntity users) {
        try {
            UsersEntity savedUsers = userService.addUser(users);
            return ResponseEntity.ok(savedUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersEntity>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<UsersEntity> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        try {
            UsersEntity user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getClientByEmail(@PathVariable String email) {
        try {
            UsersEntity user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/all/{sexeId}")
    public ResponseEntity<List<UsersEntity>> getUsersBySexe(@PathVariable int sexeId) {
        try {
            List<UsersEntity> users = userService.getUsersBySexe(sexeId);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Client deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }

    public UsersEntity updateUser(UsersEntity updatedUser) throws Exception {
        UsersEntity existingUser = usersRepository.findById(updatedUser.getIdusers())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + updatedUser.getIdusers()));

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setName(updatedUser.getName());
        existingUser.setLastname(updatedUser.getLastname());
        existingUser.setPhonenumber(updatedUser.getPhonenumber());
        existingUser.setBirthday(updatedUser.getBirthday());
        existingUser.setIsActive(updatedUser.getIsActive());

        return usersRepository.save(existingUser);
    }

    @PutMapping("/disable/user/{id}")
    public ResponseEntity<Object> deactivateUser(@PathVariable int id) {
        try {
            UsersEntity user = userService.deactivateUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }
}
