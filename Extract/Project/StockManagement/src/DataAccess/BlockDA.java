/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Block;
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
public class BlockDA {

    public static boolean Add(Block block) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(block);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(Block block) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(block);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Block block) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(block);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Block GetSingle(int Id) {

        Block block = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            block = (Block) session.get(Block.class, Id);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {

        }
        return block;
    }

    public static List<Block> GetAll() {

        List<Block> blocks = new ArrayList<Block>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        blocks = session.createCriteria(Block.class).list();
        session.getTransaction().commit();
        session.close();
        return blocks;
    }

    public static List<Block> GetAllByBuildingId(int BuildingId) {

        List<Block> blocks = new ArrayList<Block>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        String hql = String.format("From Block where BuildingId=%s", BuildingId);

        Query query = session.createQuery(hql);
        blocks = query.list();
        session.getTransaction().commit();
        session.close();
        return blocks;
    }
}
