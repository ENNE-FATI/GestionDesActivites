/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Touriste;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author FATI
 */
public class TouristeDao extends AbstractDao<Touriste> {

    public TouristeDao() {
        super(Touriste.class);
    }

    public Touriste findByNom(String nom) {
        Session session = null;
        Transaction tx = null;
        Touriste touriste = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            touriste = (Touriste) session.getNamedQuery("Touriste.findByTouriste")
                    .setParameter("nom", nom)
                    .uniqueResult();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return touriste;
    }

    public Touriste findByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        Touriste touriste = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            touriste = (Touriste) session.getNamedQuery("findByEmail")
                    .setParameter("email", email)
                    .uniqueResult();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return touriste;
    }

}
