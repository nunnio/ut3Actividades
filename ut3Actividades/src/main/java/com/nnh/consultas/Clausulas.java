package com.nnh.consultas;

import com.nnh.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Clausulas {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSf();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        String nombre = "Samuel Amat";
        int id = 6;
        Query q = ss.createQuery("update Director set anioDire = :anioDire where id = :id ");
        q.setParameter("anioDire", null);
        q.setParameter("id", 6);
        q.executeUpdate();

        System.out.println("Update ejecutado");

        // Crea un nuevo objeto en la tabla
        Query q2 = ss.createQuery("insert into Director (anioDire) select(anioDire) from Director where id = :id ");
        q2.setParameter("id", null);
        q2.executeUpdate();
        t.commit();

    }
}
