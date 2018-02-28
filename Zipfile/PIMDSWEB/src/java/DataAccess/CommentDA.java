/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Comment;
import BusinessObject.ProjectCategory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author singhj1
 */
public class CommentDA {

    public static boolean Add(Comment comment) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(comment);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(Comment comment) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(comment);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(Comment comment) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(comment);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static Comment GetSingle(int Id) {

        Comment comment = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            comment = (Comment) session.get(Comment.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return comment;
    }

    public static List<Comment> GetAll() {

        List<Comment> comments = new ArrayList<Comment>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        comments = session.createCriteria(Comment.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return comments;
    }

    public static List<Comment> GetAllnull() {

        List<Comment> comments = new ArrayList<Comment>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        String hql = String.format("From Comment where ParentId = null");
        Query query = session.createQuery(hql);
        comments = query.list();

        session.getTransaction().commit();
        session.close();
        factory.close();
        return comments;
    }

    public static List<Comment> GetAllByParentId(int ParentId) {

        List<Comment> comments = new ArrayList<Comment>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Comment.class);
        cr.add(Restrictions.eq("ParentId", ParentId));
        comments = cr.list();

        session.getTransaction().commit();
        session.close();
        factory.close();

        return comments;
    }

    public static List<Comment> GetAllTop3() {

        List<Comment> comments = new ArrayList<Comment>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Comment.class).setMaxResults(3);
        cr.addOrder(Order.desc("Id"));
        comments = cr.list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return comments;
    }
    
    public static List<Comment> GetAllByProjectDocument(int ProjectDocumentId) {

        List<Comment> comments = new ArrayList<Comment>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Comment.class);
        cr.add(Restrictions.eq("ProjectDocumentId", ProjectDocumentId));
        cr.addOrder(Order.desc("Id"));
        comments = cr.list();

        session.getTransaction().commit();
        session.close();
        factory.close();

        return comments;
    }
    
        public static List<Comment> GetAllByProjectDocumentAndParentId(int ProjectDocumentId) {

        List<Comment> comments = new ArrayList<Comment>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Comment.class);
        
        cr.add(Restrictions.and(Restrictions.eq("ProjectDocumentId", ProjectDocumentId), Restrictions.isNull("ParentId")));
        cr.addOrder(Order.desc("Id"));
        
        comments = cr.list();

        session.getTransaction().commit();
        session.close();
        factory.close();

        return comments;
    }

}
