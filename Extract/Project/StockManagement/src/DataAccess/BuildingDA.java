/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author singhj1
 */
public class BuildingDA {

    public static boolean Add(Building building) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(building);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(Building building) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(building);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Building building) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(building);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Building GetSingle(int Id) {

        Building building = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            building = (Building) session.get(Building.class, Id);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {

        }
        return building;
    }

    public static List<Building> GetAll() {

        List<Building> buildings = new ArrayList<Building>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        buildings = session.createCriteria(Building.class).list();

        session.getTransaction().commit();
        session.close();
        return buildings;
    }
}
