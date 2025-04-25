/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ActivityTouristeDao;
import entities.ActiviteTouristique;
import java.util.List;

/**
 *
 * @author FATI
 */
public class TestActivity {
   public static void main(String[] args) {
    ActivityTouristeDao ad = new ActivityTouristeDao();
    List<ActiviteTouristique> list = ad.findBetweenPrix(200.0, 700.0);

        for (ActiviteTouristique at : list) {
            System.out.println(at.getNom());
        }
    }
}
