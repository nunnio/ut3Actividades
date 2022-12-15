package com.nnh.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nom;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_genero", referencedColumnName = "id")
    private Genero genero;

    public Artista(){}

    public Artista(String nom, Genero genero) {
        this.nom = nom;
        this.genero = genero;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
