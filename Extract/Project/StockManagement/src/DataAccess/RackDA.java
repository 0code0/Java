/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Rack;
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
public class RackDA {

    public static boolean Add(Rack rack) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(rack);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public static boolean Update(Rack rack) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(rack);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Rack rack) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(rack);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Rack GetSingle(int Id) {

        Rack Rack = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Rack = (Rack) session.get(Rack.class, Id);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {

        }
        return Rack;
    }

    public static List<Rack> GetAll() {

        List<Rack> Racks = new ArrayList<Rack>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Racks = session.createCriteria(Rack.class).list();
        session.getTransaction().commit();
        session.close();
        return Racks;
    }

    public static List<Rack> GetAllByBlockId(int BlockId) {

        List<Rack> racks = new ArrayList<Rack>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        String hql = String.format("From Rack where BlockId=%s", BlockId);

        Query query = session.createQuery(hql);
        racks = query.list();
        session.getTransaction().commit();
        session.close();
        return racks;
    }
}
