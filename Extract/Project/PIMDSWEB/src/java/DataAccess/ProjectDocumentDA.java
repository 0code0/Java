/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.ProjectDocument;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author singhj1
 */
public class ProjectDocumentDA {

    public static boolean Add(ProjectDocument projectDocument) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(projectDocument);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
           
            return false;
        }

    }

    public static boolean Update(ProjectDocument projectDocument) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(projectDocument);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(ProjectDocument projectDocument) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(projectDocument);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static ProjectDocument GetSingle(int Id) {

        ProjectDocument projectDocument = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            projectDocument = (ProjectDocument) session.get(ProjectDocument.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();
            
        } catch (Exception e) {

        }
        return projectDocument;
    }

    public static List<ProjectDocument> GetAll() {

        List<ProjectDocument> projectDocuments = new ArrayList<ProjectDocument>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        projectDocuments = session.createCriteria(ProjectDocument.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return projectDocuments;
    }
    
        public static List<ProjectDocument> GetAllByProject(int ProjectId) {
        List<ProjectDocument> users = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDocument.class);
            cr.add(Restrictions.eq("ProjectId", ProjectId));
            session.getTransaction().commit();
            users = cr.list();
            session.close();
            factory.close();
            return users;

        } catch (Exception e) {
            return users;
        }
    }
        
        public static List<ProjectDocument> GetAllByProjectDocumentId(int Id) {
        List<ProjectDocument> projectDocuments = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDocument.class);
            cr.add(Restrictions.eq("Id", Id));
            session.getTransaction().commit();
            projectDocuments = cr.list();
            session.close();
            factory.close();
            return projectDocuments;

        } catch (Exception e) {
            return projectDocuments;
        }
    }
        public static List<ProjectDocument> GetAllProjectDocumentByUser(String UserName) {
        List<ProjectDocument> projectDocuments = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDocument.class);
            cr.add(Restrictions.eq("base.CreatedBy", UserName));
            session.getTransaction().commit();
            projectDocuments = cr.list();
            session.close();
            factory.close();
            return projectDocuments;

        } catch (Exception e) {
            return projectDocuments;
        }
    }
        
}
