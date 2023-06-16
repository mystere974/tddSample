package com.example.tdd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sexe", schema = "tddsample")
public class SexeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsexe")
    private int idsexe;

    public enum Sexe {
        HOMME,
        FEMME
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    private Sexe sexe;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SexeEntity that = (SexeEntity) o;

        if (idsexe != that.idsexe) return false;
        if (sexe != that.sexe) return false; // Utilisez l'égalité directe pour les ENUM


        return true;
    }

    @Override
    public int hashCode() {
        int result = idsexe;
        result = 31 * result + (sexe != null ? sexe.hashCode() : 0);
        return result;
    }
}
