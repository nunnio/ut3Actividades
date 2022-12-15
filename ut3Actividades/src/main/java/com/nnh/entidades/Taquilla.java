package com.nnh.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "taquillas")
public class Taquilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int codigo;
    @OneToOne(mappedBy = "taquilla", cascade = CascadeType.PERSIST)
    private Musico musico;

    public Taquilla() {
    }

    public Taquilla(int codigo, Musico musico) {
        this.codigo = codigo;
        this.musico = musico;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }

    @Override
    public String toString() {
        return "Taquilla{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", musico=" + musico +
                '}';
    }
}
