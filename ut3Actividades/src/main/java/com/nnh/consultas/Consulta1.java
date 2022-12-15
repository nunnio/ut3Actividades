package com.nnh.consultas;

import com.nnh.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Consulta1 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSf();
        Session ss = sf.openSession();

        // Veo la cantidad de taquillas que hay.
        Query<Long> q = ss.createQuery("select count(id) from Taquilla ", Long.class);
        Long resultado = q.uniqueResult();
        System.out.println("Hay en total "+ resultado+" taquillas.");
        ss.close();
    }
}
