/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Used;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author singhj1
 */
public class UsedDA {

    public static boolean Add(Used Used) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(Used);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(Used Used) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(Used);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Used Used) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(Used);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Used GetSingle(int Id) {

        Used Used = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Used = (Used) session.get(Used.class, Id);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {

        }
        return Used;
    }

    public static List<Used> GetAll() {

        List<Used> Useds = new ArrayList<Used>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Useds = session.createCriteria(Used.class).list();
        session.getTransaction().commit();
        session.close();
        return Useds;
    }

    public static List<Used> GetAllByPartId(int PartId) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        String hql = String.format("From Used where PartId=%s", PartId);

        Query query = session.createQuery(hql);
        session.getTransaction().commit();
        session.close();
        return query.list();
    }

}
