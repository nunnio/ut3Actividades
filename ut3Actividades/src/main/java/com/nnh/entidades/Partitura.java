package com.nnh.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "partituras")
public class Partitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "añoPublicacion")
    private int anioPublicacion;
    @Column
    private String titulo;
    @Column
    private String autor;
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Director> directores;

    public Partitura(){}

    public Partitura(int anioPublicacion, String titulo, String autor, List<Director> directores) {
        this.anioPublicacion = anioPublicacion;
        this.titulo = titulo;
        this.autor = autor;
        this.directores = directores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    @Override
    public String toString() {
        return "Partitura{" +
                "id=" + id +
                ", anioPublicacion=" + anioPublicacion +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", directores=" + directores +
                '}';
    }
}
