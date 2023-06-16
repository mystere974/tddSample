package com.example.tdd.repository;

import com.example.tdd.model.SexeEntity;
import com.example.tdd.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByEmail(String email);
    List<UsersEntity> findBySexe(SexeEntity sexeId);
}

