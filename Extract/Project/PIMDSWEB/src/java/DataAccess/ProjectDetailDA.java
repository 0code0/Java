/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Base;
import BusinessObject.ProjectDetail;
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
public class ProjectDetailDA {

    public static boolean Add(ProjectDetail projectDetail) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(projectDetail);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public static boolean Update(ProjectDetail projectDetail) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(projectDetail);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public static boolean Delete(ProjectDetail projectDetail) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(projectDetail);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static ProjectDetail GetSingle(int Id) {

        ProjectDetail projectDetail = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            projectDetail = (ProjectDetail) session.get(ProjectDetail.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return projectDetail;
    }

    public static List<ProjectDetail> GetAll() {

        List<ProjectDetail> projectDetails = new ArrayList<ProjectDetail>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        projectDetails = session.createCriteria(ProjectDetail.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return projectDetails;
    }

    public static List<ProjectDetail> GetAllByProjectCategory(int ProjectCategoryId) {
        List<ProjectDetail> projectDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("ProjectCategoryId", ProjectCategoryId));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }

    public static List<ProjectDetail> Complete() {
        List<ProjectDetail> projectDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("Status", "complete"));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }

    public static List<ProjectDetail> Halt() {
        List<ProjectDetail> projectDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("Status", "halt"));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }

    public static List<ProjectDetail> Running() {
        List<ProjectDetail> projectDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("Status", "running"));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }

    public static List<ProjectDetail> GetAllByProjectDetailId(int Id) {
        List<ProjectDetail> projectDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("Id", Id));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }
    
     public static List<ProjectDetail> GetAllProjectByUser( String UserName ) {
        List<ProjectDetail> projectDetails = null;
        
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("base.CreatedBy", UserName));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }
     
        public static List<ProjectDetail> GetAllProjectDetailByProjectClass(int ProjectClassId) {
        List<ProjectDetail> projectDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(ProjectDetail.class);
            cr.add(Restrictions.eq("ProjectClassId", ProjectClassId));
            session.getTransaction().commit();
            projectDetails = cr.list();
            session.close();
            factory.close();
            return projectDetails;

        } catch (Exception e) {
            return projectDetails;
        }
    }

}
