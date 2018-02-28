/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.LegendsCategory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author singhj1
 */
public class LegendsCategoryDA {

    public static boolean Add(LegendsCategory legendsCategory) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(legendsCategory);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(LegendsCategory legendsCategory) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(legendsCategory);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(LegendsCategory legendsCategory) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(legendsCategory);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static LegendsCategory GetSingle(int Id) {

        LegendsCategory legendsCategory = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            legendsCategory = (LegendsCategory) session.get(LegendsCategory.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return legendsCategory;
    }

    public static List<LegendsCategory> GetAll() {

        List<LegendsCategory> legendsCategorys = new ArrayList<LegendsCategory>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        legendsCategorys = session.createCriteria(LegendsCategory.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return legendsCategorys;
    }

}
