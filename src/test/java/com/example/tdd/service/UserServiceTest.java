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
    void addUser() throws Exception {
        UsersEntity user = new UsersEntity();
        // Initialisez les propriétés de user
        // ...

        UsersEntity addedUser = userService.addUser(user);

        assertNotNull(addedUser);
        // Effectuez d'autres vérifications sur le user ajouté si nécessaire
        // Ce test passe si l'on ajoute un user et que l'on met notre h2 en update
    }

    @Test
    void getAllUsers() throws Exception {
        List<UsersEntity> users = userService.getAllUsers();
        assertEquals(5, users.size());
        // Effectuez d'autres vérifications sur les utilisateurs récupérés si nécessaire

    }

    @Test
    void getUserById() throws Exception {
        int userId = 1; // ID d'un utilisateur existant
        UsersEntity user = userService.getUserById(userId);

        assertNotNull(user);
        assertEquals(userId, user.getIdusers());
        // Effectuez d'autres vérifications sur l'utilisateur récupéré si nécessaire
    }

    @Test
    void getUserByEmail() throws Exception {
        String email = "michael@example.com"; // Email d'un utilisateur existant
        UsersEntity user = userService.getUserByEmail(email);

        assertNotNull(user);
        assertEquals(email, user.getEmail());
        // Effectuez d'autres vérifications sur l'utilisateur récupéré si nécessaire
    }

    @Test
    void getUsersBySexe() throws Exception {
        int sexeId = 1;
        // Initialisez les propriétés du sexe
        List<UsersEntity> users = userService.getUsersBySexe(sexeId);

        // Vérifiez que la liste d'utilisateurs n'est pas vide ou effectuez d'autres vérifications si nécessaire
        assertNotNull(users);
        // Autres assertions...
    }

    @Test
    void deleteUser() throws Exception {
        int userId = 1; // ID de l'utilisateur à supprimer
        userService.deleteUser(userId);

        // Vérifiez que l'utilisateur a été supprimé de la base de données ou effectuez d'autres vérifications si nécessaire
    }

    @Test
    void deactivateUser() throws Exception {
        int userId = 1; // ID de l'utilisateur à désactiver
        userService.deactivateUser(userId);

        // Vérifiez que l'utilisateur a été désactivé ou effectuez d'autres vérifications si nécessaire
    }

    @Test
    void updateUser() throws Exception {
        UsersEntity updatedUser = new UsersEntity();
        // Initialisez les propriétés de l'utilisateur mis à jour
        // ...

        UsersEntity user = userService.updateUser(updatedUser);

        assertNotNull(user);
        // Effectuez d'autres vérifications sur l'utilisateur mis à jour si nécessaire
    }
}