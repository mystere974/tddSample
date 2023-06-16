package com.example.tdd.service;

import com.example.tdd.model.SexeEntity;
import com.example.tdd.model.UsersEntity;
import com.example.tdd.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersEntity addUser(UsersEntity user) throws Exception {
        //return usersRepository.save(user);
        throw new Exception("not implemented");
    }

    public List<UsersEntity> getAllUsers() throws Exception {
        return usersRepository.findAll();
        //throw new Exception("not implemented");
    }

    public UsersEntity getUserById(int id) throws Exception{
        //return usersRepository.findById(id)
               // .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        throw new Exception("not implemented");
    }

    public UsersEntity getUserByEmail(String email) throws Exception {

        //return usersRepository.findByEmail(email);
        throw new Exception();
    }

    public List<UsersEntity> getUsersBySexe(SexeEntity sexe) throws Exception {

        //return usersRepository.findBySexe(sexe);
        throw new Exception();
    }

    public void deleteUser(int id) throws Exception {

        //usersRepository.deleteById(id);
        throw new Exception();
    }

    public void deactivateUser(int id) throws Exception {
        //UsersEntity user = usersRepository.findById(id)
        //        .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        //user.setIsActive("false");
       //usersRepository.save(user);
        throw new Exception();
    }

    public UsersEntity updateUser(UsersEntity updatedUser) throws Exception {
        //UsersEntity existingUser = usersRepository.findById(updatedUser.getIdusers())
        //        .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + updatedUser.getIdusers()));

        //existingUser.setEmail(updatedUser.getEmail());
        //existingUser.setName(updatedUser.getName());
        //existingUser.setLastname(updatedUser.getLastname());
        //existingUser.setPhonenumber(updatedUser.getPhonenumber());
        //existingUser.setBirthday(updatedUser.getBirthday());
        //existingUser.setIsActive(updatedUser.getIsActive());

        //return usersRepository.save(existingUser);
        throw new Exception();
    }
}
