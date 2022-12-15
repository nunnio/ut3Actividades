package com.nnh.consultas;

import com.nnh.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consulta2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSf();
        Session ss = sf.openSession();
        // Veo el código de taquilla que tiene cada músico.
        Query<Object[]> q6 = ss.createQuery("select M.nom, T.codigo from Musico M, Taquilla  T where T.id = M.taquilla");
        List<Object[]> musicos = q6.list();
        for(Object[] o : musicos){
            System.out.println("Músico "+ o[0] + " tiene el código de taquilla "+o[1]);
        }
    }
}
