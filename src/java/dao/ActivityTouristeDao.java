/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.ActiviteTouristique;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author FATI
 */
public class ActivityTouristeDao extends AbstractDao<ActiviteTouristique> {

    public ActivityTouristeDao() {
        super(ActiviteTouristique.class);
    }
    public List<ActiviteTouristique> findBetweenPrix(double p1, double p2) {
        Session session = null;
        Transaction tx = null;
        List<ActiviteTouristique> activites = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            activites = session.getNamedQuery("findBetweenPrix").setParameter("p1", p1).setParameter("p2", p2).list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return activites;
    }

}