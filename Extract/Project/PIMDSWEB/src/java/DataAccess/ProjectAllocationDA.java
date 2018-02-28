/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.ProjectAllocation;
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
public class ProjectAllocationDA {

    public static boolean Add(ProjectAllocation projectAllocation) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(projectAllocation);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(ProjectAllocation projectAllocation) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(projectAllocation);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(ProjectAllocation projectAllocation) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(projectAllocation);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static ProjectAllocation GetSingle(int Id) {

        ProjectAllocation projectAllocation = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            projectAllocation = (ProjectAllocation) session.get(ProjectAllocation.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return projectAllocation;
    }

    public static List<ProjectAllocation> GetAll() {

        List<ProjectAllocation> projectAllocations = new ArrayList<ProjectAllocation>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        projectAllocations = session.createCriteria(ProjectAllocation.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return projectAllocations;
    }

    public static List<ProjectAllocation> GetAllByProjectDetailId(int ProjectDetailId) {
        List<ProjectAllocation> projectAllocations = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectAllocation.class);
            cr.add(Restrictions.eq("ProjectDetailId", ProjectDetailId));
            session.getTransaction().commit();
            projectAllocations = cr.list();
            session.close();
            factory.close();
            return projectAllocations;

        } catch (Exception e) {
            return projectAllocations;
        }
    }
    
    public static ProjectAllocation GetSingleByProjectDetailId(int ProjectDetailId) {
        ProjectAllocation projectAllocations = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectAllocation.class);
            cr.add(Restrictions.eq("ProjectDetailId", ProjectDetailId)).setMaxResults(1);
            projectAllocations = (ProjectAllocation) cr.list();
            session.getTransaction().commit();
            
            session.close();
            factory.close();
            return projectAllocations;

        } catch (Exception e) {
            return projectAllocations;
        }
    }
}
