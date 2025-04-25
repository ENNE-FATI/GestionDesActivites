/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.ReservationActivity;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author FATI
 */
public class ReservationActivityDao extends AbstractDao<ReservationActivity> {

    public ReservationActivityDao() {
        super(ReservationActivity.class);
    }
  public List<Object[]> findNamesByDate(LocalDate date) {
    Session session = null;
    Transaction tx = null;
    List<Object[]> results = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        results = session.getNamedQuery("findNamesByDate")
                         .setParameter("date", date)
                         .list();

        tx.commit();
    } catch (Exception ex) {
        if (tx != null) tx.rollback();
        ex.printStackTrace();
    } finally {
        if (session != null) session.close();
    }

    return results;
}

}

