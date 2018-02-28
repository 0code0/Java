/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Quantity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author singhj1
 */
public class QuantityDA {

    public static boolean Add(Quantity Quantity) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(Quantity);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        }

    }

    public static boolean Update(Quantity Quantity) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(Quantity);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Quantity Quantity) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(Quantity);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Quantity GetSingle(int Id) {

        Quantity Quantity = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Quantity = (Quantity) session.get(Quantity.class, Id);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {

        }
        return Quantity;
    }

    public static List<Quantity> GetAll() {

        List<Quantity> Quantitys = new ArrayList<Quantity>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Quantitys = session.createCriteria(Quantity.class).list();
        session.getTransaction().commit();
        session.close();
        return Quantitys;
    }

    public static List<Quantity> GetAllByPartsId(int PartId) {
        List<Quantity> Quantitys = new ArrayList<Quantity>();
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            String hql = String.format("From Quantity where PartsId=%s", PartId);

            Query query = session.createQuery(hql);
            Quantitys = query.list();
            session.getTransaction().commit();
            session.close();
            return Quantitys;

        } catch (Exception e) {

        }

        return Quantitys;
    }

    public static Quantity GetSingleByPartId(int PartId) {

        Quantity quantity = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Quantity.class).add(Restrictions.eq("PartsId", PartId)).setMaxResults(1).addOrder(Order.desc("Id"));
            
            quantity = (Quantity) criteria.uniqueResult();
           
            session.getTransaction().commit();
            session.close();
            return quantity;
        } catch (Exception e) {
            return quantity;
        }

    }
}
