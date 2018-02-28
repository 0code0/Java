/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Document;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author singhj1
 */
public class DocumentDA {

    public static boolean Add(Document document) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {

            session.beginTransaction();
            session.save(document);
            session.getTransaction().commit();

            return true;

        } catch (Exception e) {
            return false;
        } finally {

            session.close();
            factory.close();
        }

    }

    public static boolean Update(Document document) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        try {

            session.beginTransaction();

            session.saveOrUpdate(document);

            session.getTransaction().commit();

            return true;

        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        } finally {

            session.close();
            factory.close();
        }

    }

    public static boolean Delete(Document document) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        try {

            session.beginTransaction();

            session.delete(document);

            session.getTransaction().commit();

            return true;

        } catch (Exception e) {
            return false;
        } finally {

            session.close();
            factory.close();
        }

    }

    public static Document GetSingle(int Id) {

        Document document = null;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {

            session.beginTransaction();

            document = (Document) session.get(Document.class, Id);

            session.getTransaction().commit();

        } catch (Exception e) {

        } finally {
            session.close();
            factory.close();
            return document;
        }

    }

    public static List<Document> GetAll() {
        List<Document> documents = new ArrayList<Document>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            documents = session.createCriteria(Document.class).list();
            session.getTransaction().commit();

        } catch (Exception ex) {

        } finally {

            session.close();
            factory.close();

        }
        return documents;
    }

    public static List<Document> GetAllByDocumentId(int Id) {
        List<Document> documents = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(Document.class);
            cr.add(Restrictions.eq("Id", Id));
            session.getTransaction().commit();
            documents = cr.list();
            session.close();
            factory.close();
            return documents;

        } catch (Exception e) {
            return documents;
        }
    }

    public static List<Document> GetAllnull() {
        List<Document> documents = new ArrayList<Document>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            String hql = String.format("From Document where ParentId = null");
            Query query = session.createQuery(hql);

            documents = query.list();
            session.getTransaction().commit();
            return documents;
        } catch (Exception ex) {

        } finally {

            session.close();
            factory.close();

        }
        return documents;
    }
    
    public static List<Document> GetAllByParentId(int ParentId) {
        List<Document> documents = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(Document.class);
            cr.add(Restrictions.eq("ParentId", ParentId));
            session.getTransaction().commit();
            documents = cr.list();
            session.close();
            factory.close();
            return documents;

        } catch (Exception e) {
            return documents;
        }
    }
}
