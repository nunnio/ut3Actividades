package com.nnh;
import com.nnh.entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSf();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        /*      -- Relaciones --

           Relación unidireccional entre artista y género
           Relación bidirecional entre músicos y taquillas
           Relación uno a muchos entre músicos y cuerdas
           Relación muchos a muchos entre director y partituras
           Director hereda de Musico

           -Al persistir las cuerdas, persisto a su vez los músicos los cuales, como les he añadido las
           taquillas añadidas al principio, también las debería tener.
           Como es una relación bidireccional, las taquillas deberían a su vez tener sus respectivos musicos.
           -Al persistir las partituras, deberían persistirser a su vez los directores a los cuales están enlazados.

        */

        // Relación unidireccional entre artista y género
        Genero genero = new Genero("Soul");
        Artista artista = new Artista("Shirley Davis",genero);

        // Creo las taquillas primero
        Taquilla t1 = new Taquilla(1701, null);
        Taquilla t2 = new Taquilla(5602, null);
        Taquilla t3 = new Taquilla(3303, null);
        Taquilla t4 = new Taquilla(4504, null);
        Taquilla t5 = new Taquilla(1305, null);

        // Creo los músicos y los añado a las respectivas listas
        Musico m1 = new Musico(17, "Inés Navarro", t1, null);
        Musico m2 = new Musico(56, "Mariluz Cuesta", t2, null);
        Musico m3 = new Musico(13, "Alejandro Pérez", t5, null);
        List<Musico> musicosClarinete = new ArrayList<>();
        List<Musico> musicosTrombones = new ArrayList<>();
        List<Musico> musicosPercusion = new ArrayList<>();
        musicosClarinete.add(m1);
        musicosTrombones.add(m2);
        musicosPercusion.add(m3);

        // Director hereda de músico, añado los directores a su lista
        List<Director> directores = new ArrayList<>();
        Director d1 = new Director(33, "Juan Pedro Enguidanos", t3, null, 4, "Sax", null);
        Director d2 = new Director(45, "Jose Clavel", t4, null, 10, "Aspe", null);
        directores.add(d1);
        directores.add(d2);

        //Creo las partituras, las añado a su lista
        Partitura p1 = new Partitura(1880, "1812", "Chaikovski", directores);
        Partitura p2 = new Partitura(1803, "Sinfonía nº.3","Beethoven", directores);
        Partitura p3 = new Partitura(1717, "Concerto for 2 Violins in D Minor, BWV 1043: I. Vivace","Bach", directores);

        List<Partitura> partituras = new ArrayList<>();
        partituras.add(p1);
        partituras.add(p2);
        partituras.add(p3);


        // Creo las cuerdas con las respectivas listas cuerda, que contienen músicos
        Cuerda c1 = new Cuerda("Clarinetes", 'd', musicosClarinete);
        Cuerda c2 = new Cuerda("Trombones", 't', musicosTrombones);
        Cuerda c3 = new Cuerda("Percusión", 'p', musicosPercusion);

        // Creo que este paso se debería obviar ya que lo debería hacer el hibernate, TODO ZYZYYZYZYZ
        m1.setCuerda(c1);
        m2.setCuerda(c2);
        m3.setCuerda(c3);
        d1.setCuerda(c1);
        d2.setCuerda(c3);
        d1.setPartituras(partituras);
        d2.setPartituras(partituras);

        // Persisto sólo artista, cuerdas y partituras.
        ss.persist(artista);
        ss.persist(c1);
        ss.persist(c2);
        ss.persist(c3);
        ss.persist(p1);
        ss.persist(p2);
        ss.persist(p3);
        t.commit();
        ss.close();
    }
}
