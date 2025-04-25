/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.TouristeDao;
import entities.ReservationActivity;
import entities.Touriste;
import java.util.List;

/**
 *
 * @author FATI
 */
public class TouristeTest {
  public static void main(String[] args) {
        TouristeDao dao = new TouristeDao();

        String emailRecherche = "ennesyryfati@gmail.com";  

        Touriste t = dao.findByEmail(emailRecherche);

        if (t != null) {
            System.out.println("Touriste trouvé !");
            System.out.println("Nom     : " + t.getNom());
            System.out.println("Email   : " + t.getEmail());
        } else {
            System.out.println("Aucun touriste trouvé avec l'email : " + emailRecherche);
        }
    }
}

