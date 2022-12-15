package com.nnh.consultas;

import com.nnh.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Consulta3 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSf();
        Session ss = sf.openSession();

        // Veo el nombre de los músicos ordenado descendentemente.
        Query<String> q3 = ss.createQuery("Select M.nom from Musico M order by nom desc");
        Iterator<String> musicos1 = q3.stream().iterator();
        while (musicos1.hasNext()){
            System.out.println(musicos1.next());
        }
        ss.close();
    }
}
