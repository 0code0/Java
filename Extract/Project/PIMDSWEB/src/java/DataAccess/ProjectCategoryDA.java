/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.ProjectCategory;
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
public class ProjectCategoryDA {

    public static boolean Add(ProjectCategory projectCategory) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();
      
            
            session.save(projectCategory);
            
            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            
            return false;
        }

    }

    public static boolean Update(ProjectCategory projectCategory) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(projectCategory);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(ProjectCategory projectCategory) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(projectCategory);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
            
        }

    }

    public static ProjectCategory GetSingle(int Id) {

        ProjectCategory projectCategory = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            projectCategory = (ProjectCategory) session.get(ProjectCategory.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return projectCategory;
    }

    public static List<ProjectCategory> GetAll() {
      List<ProjectCategory> projectCategorys = null;
        try {
           
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        projectCategorys = session.createCriteria(ProjectCategory.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return projectCategorys;
        
        } catch (Exception e) {
            return projectCategorys;
        }
    }
    
      public static List<ProjectCategory> GetAllnull() {
      List<ProjectCategory> projectCategorys = null;
        try {
           
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        String hql = String.format("From ProjectCategory where ParentId = null" );
        
        Query query = session.createQuery(hql);
        projectCategorys = query.list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return projectCategorys;
        
        } catch (Exception e) {
            return projectCategorys;
        }
    }
      
    public static List<ProjectCategory> GetAllByParentId(int ParentId) {
        List<ProjectCategory> projectCategorys = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectCategory.class);
            cr.add(Restrictions.eq("ParentId", ParentId));
            session.getTransaction().commit();
            projectCategorys = cr.list();
            session.close();
            factory.close();
            return projectCategorys;

        } catch (Exception e) {
            return projectCategorys;
        }
    }
}
