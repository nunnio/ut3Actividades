package com.nnh.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "musicos")
@DiscriminatorColumn(name = "funcion", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "M")
public class Musico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int edad;
    @Column(name = "nombre")
    private String nom;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_taquilla", referencedColumnName = "id")
    private Taquilla taquilla;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_cuerda", referencedColumnName = "id")
    private Cuerda cuerda;


    public Musico(){}

    public Musico(int edad, String nom, com.nnh.entidades.Taquilla taquilla, Cuerda cuerda) {
        this.edad = edad;
        this.nom = nom;
        this.taquilla = taquilla;
        this.cuerda = cuerda;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public com.nnh.entidades.Taquilla getTaquilla() {
        return taquilla;
    }

    public void setTaquilla(com.nnh.entidades.Taquilla taquilla) {
        this.taquilla = taquilla;
    }

    public Cuerda getCuerda() {
        return cuerda;
    }

    public void setCuerda(Cuerda cuerda) {
        this.cuerda = cuerda;
    }

    @Override
    public String toString() {
        return "Musico{" +
                "id=" + id +
                ", edad=" + edad +
                ", nom='" + nom + '\'' +
                ", Taquilla=" + taquilla +
                ", cuerda=" + cuerda +
                '}';
    }
}
