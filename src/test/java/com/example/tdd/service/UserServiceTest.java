package com.example.tdd.service;

import com.example.tdd.model.SexeEntity;
import com.example.tdd.model.UsersEntity;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    void addUser(UsersEntity user) throws Exception {
        userService.addUser(user);
    }

    @Test
    void getAllUsers() throws Exception {
        List<UsersEntity> users = userService.getAllUsers();
        assertEquals(5, users.size());
    }

    @Test
    void getUserById(int id) throws Exception {
        userService.getUserById(id);
    }

    @Test
    void getUserByEmail(String email) throws Exception {
        userService.getUserByEmail(email);
    }

    @Test
    void getUsersBySexe(SexeEntity sexe) throws Exception {
        userService.getUsersBySexe(sexe);
    }

    @Test
    void deleteUser(int id) throws Exception {
        userService.deleteUser(id);
    }

    @Test
    void deactivateUser(int id) throws Exception {
        userService.deactivateUser(id);
    }

    @Test
    void updateUser(UsersEntity updatedUser) throws Exception {
        userService.updateUser(updatedUser);
    }
}