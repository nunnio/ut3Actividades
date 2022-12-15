package com.nnh.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cuerdas")
public class Cuerda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nom;
    @Column
    private char familia;


    @OneToMany(mappedBy = "cuerda", cascade = CascadeType.PERSIST)
    private List<Musico> musicos;

    public Cuerda() {
    }

    public Cuerda(String nom, char familia, List<Musico> musicos) {
        this.nom = nom;
        this.familia = familia;
        this.musicos = musicos;
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

    public char getFamilia() {
        return familia;
    }

    public void setFamilia(char familia) {
        this.familia = familia;
    }

    public List<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(List<Musico> musicos) {
        this.musicos = musicos;
    }

    @Override
    public String toString() {
        return "Cuerda{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", familia=" + familia +
                ", musicos=" + musicos +
                '}';
    }
}
