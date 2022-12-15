package com.nnh.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nom;

    public Genero(){}

    public Genero(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
