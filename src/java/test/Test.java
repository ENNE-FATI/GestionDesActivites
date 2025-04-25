package test;

import dao.*;
import entities.*;

import util.HibernateUtil;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();

        UserDao userDao = new UserDao();
        AdminDao adminDao = new AdminDao();
        TouristeDao touristeDao = new TouristeDao();
        GuideDao guideDao = new GuideDao();
        ActivityTouristeDao activiteDao = new ActivityTouristeDao();
        ReservationActivityDao reservationDao = new ReservationActivityDao();

        Admin ad1 = new Admin("Safi",  "safi@example.com", "Safi123");
        userDao.create(ad1);

        Touriste t1 = new Touriste("EN-NESYRY", "ennesyryfati@gmail.com", "Fati123");
        Touriste t2 = new Touriste("SWIFT", "john@gmail.com", "john03");
        userDao.create(t1);
        userDao.create(t2);

        Guide g1 = new Guide("Français", "ERRAFI",  "ennesyryfati@gmail.com", "Fati123");
        Guide g2 = new Guide("Arabe", "NACIRI",  "naciri@gmail.com", "Soukaina123");
        Guide g3 = new Guide("Anglais", "SOUHA",  "lina@gmail.com", "lina123");
        userDao.create(g1);
        userDao.create(g2);
        userDao.create(g3);

        ActiviteTouristique a1 = new ActiviteTouristique("Surf", "Taghazout", 300.0f, "Cours de surf pour débutants et confirmés",g1);
        ActiviteTouristique a2 = new ActiviteTouristique("Quad", "Ennakhil", 250.0f, "Une heure de Quad",g2);
        ActiviteTouristique a3 = new ActiviteTouristique("Équitation", "Essaouira", 600.0f, "Tour à la plage avec photographe",g1);
        ActiviteTouristique a4 = new ActiviteTouristique("Visite des monuments historiques", "Marrakech", 50.0f, "Découverte de l'architecture marocaine",g2);
        activiteDao.create(a1);
        activiteDao.create(a2);
        activiteDao.create(a3);
        activiteDao.create(a4);

        ReservationActivity res1 = new ReservationActivity(a1, t1, LocalDate.of(2025, 4, 15));  
        ReservationActivity res2 = new ReservationActivity(a2, t2, LocalDate.of(2025, 4, 16));  

        reservationDao.create(res1);
        reservationDao.create(res2);

        System.out.println("\nRéservations des touristes :");
        for (ReservationActivity res : reservationDao.findAll()) {
            System.out.println("Touriste: " + res.getTouriste().getNom() + " " + res.getTouriste().getNom());
            System.out.println("Activité: " + res.getActivite().getNom() + " à " + res.getActivite().getLieu());
            System.out.println("Date de réservation: " + res.getReservationDate());

        }
        System.out.println("\nGuides parlant français :");
        for (Guide g : guideDao.findAll()) {
            if ("Français".equalsIgnoreCase(g.getLangue())) {
                System.out.println(g.getNom() + " " + g.getEmail() + " (Langue: " + g.getLangue() + ")");
            }
        }
        
        System.out.println("\nRéservations de Fatima Zahra :");
        for (ReservationActivity res : reservationDao.findAll()) {
            if (res.getTouriste().getId() == t1.getId()) {
                System.out.println(res.getActivite().getNom() + " à " + res.getActivite().getLieu() + " le " + res.getReservationDate());
            }
        }

        System.out.println("\nActivités gérées par les Guides :");
        for (Guide g : guideDao.findAll()) {
            System.out.println("\nGuide: " + g.getNom() + " " + g.getEmail() + " (Langue: " + g.getLangue() + ")");
           }
        
        System.out.println("\nListe des Administrateurs :");
        for (Admin admin : adminDao.findAll()) {
            System.out.println(admin.getNom() + " " + " (Email: " + admin.getEmail() + ")");
        }

        System.out.println("\nRéservations des Touristes :");
        for (Touriste t : touristeDao.findAll()) {
            System.out.println("\nTouriste: " + t.getNom() + " " + t.getEmail());
            for (ReservationActivity res : reservationDao.findAll()) {
                if (res.getTouriste().getId() == t.getId()) {
                    System.out.println("Réservation: " + res.getActivite().getNom() + " à " + res.getActivite().getLieu() + " le " + res.getReservationDate());
                }
            }
        }
    }
}
