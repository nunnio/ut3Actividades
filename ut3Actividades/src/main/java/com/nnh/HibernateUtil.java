package com.nnh;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;
    private HibernateUtil(SessionFactory sf){
        this.sf = sf;}

    public static SessionFactory getSf(){
        if(sf == null){
            sf = new Configuration().configure().buildSessionFactory(
                    new StandardServiceRegistryBuilder().configure().build()
            );
        }
        return sf;
    }
}
