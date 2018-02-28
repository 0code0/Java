/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.LegendsDetail;
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
public class LegendsDetailDA {

    public static boolean Add(LegendsDetail legendsDetail) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.save(legendsDetail);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Update(LegendsDetail legendsDetail) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.saveOrUpdate(legendsDetail);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean Delete(LegendsDetail legendsDetail) {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(legendsDetail);

            session.getTransaction().commit();
            session.close();
            factory.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public static LegendsDetail GetSingle(int Id) {

        LegendsDetail legendsDetail = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            legendsDetail = (LegendsDetail) session.get(LegendsDetail.class, Id);

            session.getTransaction().commit();
            session.close();
            factory.close();

        } catch (Exception e) {

        }
        return legendsDetail;
    }

    public static List<LegendsDetail> GetAll() {

        List<LegendsDetail> legendsDetails = new ArrayList<LegendsDetail>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        legendsDetails = session.createCriteria(LegendsDetail.class).list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return legendsDetails;
    }

    public static List<LegendsDetail> GetAllRandom() {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(LegendsDetail.class);
        criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
        criteria.setMaxResults(5);
        session.getTransaction().commit();
        session.close();
        factory.close();
        return criteria.list();
    }

    public static List<LegendsDetail> GetAllByProjectCategory(int CategoryId) {
        List<LegendsDetail> legendsDetails = null;
        try {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            Session session = factory.openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(LegendsDetail.class);
            cr.add(Restrictions.eq("CategoryId", CategoryId));
      
            session.getTransaction().commit();
            legendsDetails = cr.list();
            session.close();
            factory.close();
            return legendsDetails;

        } catch (Exception e) {
            return legendsDetails;
        }
    }
}
