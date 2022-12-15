package com.nnh.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directores")
@DiscriminatorValue("D")
public class Director extends Musico {
    @Column(name = "anioDeDireccion")
    private int anioDire;
    @Column
    private String poblacion;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "director_partitura",
            joinColumns = {@JoinColumn(name = "FK_director", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "FK_partitura", referencedColumnName = "id")})
    List<Partitura> partituras;


    public Director(){super();}

    public Director(int edad, String nom, Taquilla taquilla, Cuerda cuerda, int anioDire, String poblacion, List<Partitura> partituras) {
        super(edad, nom, taquilla, cuerda);
        this.anioDire = anioDire;
        this.poblacion = poblacion;
        this.partituras = partituras;
    }

    public int getAnioDire() {
        return anioDire;
    }

    public void setAnioDire(int anioDire) {
        this.anioDire = anioDire;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public List<Partitura> getPartituras() {
        return partituras;
    }

    public void setPartituras(List<Partitura> partituras) {
        this.partituras = partituras;
    }

    @Override
    public String toString() {
        return "Director{" +
                "anioDire=" + anioDire +
                ", poblacion='" + poblacion + '\'' +
                ", partituras=" + partituras +
                '}';
    }
}
