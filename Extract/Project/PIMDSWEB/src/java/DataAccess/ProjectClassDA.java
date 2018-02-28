/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.ProjectClass;
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
public class ProjectClassDA {

    public static boolean Add(ProjectClass projectClass) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(projectClass);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(ProjectClass projectClass) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(projectClass);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(ProjectClass projectClass) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(projectClass);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static ProjectClass GetSingle(int Id) {

        ProjectClass projectClass = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            projectClass = (ProjectClass) session.get(ProjectClass.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return projectClass;
    }

    public static List<ProjectClass> GetAll() {

        List<ProjectClass> projectClasss = new ArrayList<ProjectClass>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        projectClasss = session.createCriteria(ProjectClass.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return projectClasss;
    }

    public static List<ProjectClass> GetAllnull() {
        List<ProjectClass> projectClass = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            String hql = String.format("From ProjectClass where ParentId = null");

            Query query = session.createQuery(hql);
            projectClass = query.list();
            session.getTransaction().commit();
            session.close();
            factory.close();
            return projectClass;

        } catch (Exception e) {
            return projectClass;
        }
    }

    public static List<ProjectClass> GetAllByParentId(int ParentId) {
        List<ProjectClass> projectClasss = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectClass.class);
            cr.add(Restrictions.eq("ParentId", ParentId));
            session.getTransaction().commit();
            projectClasss = cr.list();
            session.close();
            factory.close();
            return projectClasss;

        } catch (Exception e) {
            return projectClasss;
        }
    }
}
