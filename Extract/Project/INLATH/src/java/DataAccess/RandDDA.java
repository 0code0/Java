/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Randd;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author singhj1
 */
public class RandDDA {
    
        public static boolean Add(Randd randd) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(randd);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(Randd randd) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(randd);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Randd randd) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(randd);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Randd GetSingle(int Id) {

        Randd randd = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            randd = (Randd) session.get(Randd.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return randd;
    }

    public static List<Randd> GetAll() {

        List<Randd> randds = new ArrayList<Randd>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        randds = session.createCriteria(Randd.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return randds;
    }
    
}
