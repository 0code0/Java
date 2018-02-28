/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author singhj1
 */
public class UserDA {

    public static boolean Add(User user) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public static boolean Update(User user) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(user);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(User user) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static User GetSingle(int Id) {

        User user = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            user = (User) session.get(User.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return user;
    }

    public static List<User> GetAll() {

        List<User> users = new ArrayList<User>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        users = session.createCriteria(User.class).addOrder(Order.asc("Name")).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return users;
    }

    public static List<User> GetAllByUserId(int Id) {
        List<User> users = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("Id", Id));
            session.getTransaction().commit();
            users = cr.list();
            session.close();
            factory.close();
            return users;

        } catch (Exception e) {
            return users;
        }
    }

    public static User IsValidUser(String UserName) {
        User users = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("UserName", UserName));
            session.getTransaction().commit();

            users = (User) cr.uniqueResult();
            session.close();
            factory.close();
            return users;

        } catch (Exception e) {
            return users;
        }
    }

    public static List<User> GetAllUserByProjectCategory(int ProjectCategoryId) {
        List<User> users = null;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {

            session.beginTransaction();

            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("ProjectCategoryId", ProjectCategoryId));
            session.getTransaction().commit();
            users = cr.list();
            return users;

        } catch (Exception e) {
            return users;
        } finally {

            session.close();
            factory.close();

        }
    }

}
