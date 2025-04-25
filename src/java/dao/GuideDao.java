/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Guide;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hibaa
 */
public class GuideDao extends AbstractDao<Guide> {

    public GuideDao() {
        super(Guide.class);
    }
   public List<Guide> findGuidesWithActivities() {
    Session session = null;
    Transaction tx = null;
    List<Guide> guides = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        // HQL : on travaille avec les entités, pas avec les tables
        String hql = "SELECT DISTINCT g FROM Guide g JOIN g.activites a";
       guides = session.createQuery(hql).list();
guides = (List<Guide>) session.createQuery(hql).list();

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }

    return guides;
}


}
