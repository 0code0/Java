/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Parts;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author singhj1
 */
public class PartsDA {

    public static boolean Add(Parts parts) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(parts);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        }

    }

    public static boolean Update(Parts parts) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(parts);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Parts parts) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(parts);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Parts GetSingle(int Id) {

        Parts Parts = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Parts = (Parts) session.get(Parts.class, Id);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {

        }
        return Parts;
    }

    public static List<Parts> GetAll() {

        List<Parts> Partss = new ArrayList<Parts>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Partss = session.createCriteria(Parts.class).list();
        session.getTransaction().commit();
        session.close();
        return Partss;
    }

    public static List<Parts> GetAllByRackId(int RackId) {

        List<Parts> Partss = new ArrayList<Parts>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        String hql = String.format("From Parts where RackID=%s", RackId);

        Query query = session.createQuery(hql);
        Partss = query.list();

        session.getTransaction().commit();
        session.close();
        return Partss;
    }

    public static List<Parts> Search(String KeyWord) {
        Query query = null;
        try {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(Parts.class);
        
        cr.add(Restrictions.like("Name", KeyWord, MatchMode.START));
      
        return cr.list();
        
        } catch (Exception e) {
            
            return query.list();
        }
        
    }

}
