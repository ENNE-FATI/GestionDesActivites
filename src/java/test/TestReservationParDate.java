/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ReservationActivityDao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author FATI
 */
public class TestReservationParDate {
    public static void main(String[] args) {
        ReservationActivityDao dao = new ReservationActivityDao();
        LocalDate date = LocalDate.of(2025, 4, 16); 

        List<Object[]> liste = dao.findNamesByDate(date);

        for (Object[] obj : liste) {
            String nomTouriste = (String) obj[0];
            String nomActivite = (String) obj[1];

            System.out.println("Touriste : " + nomTouriste + " - Activité : " + nomActivite);
        }
    }
}

