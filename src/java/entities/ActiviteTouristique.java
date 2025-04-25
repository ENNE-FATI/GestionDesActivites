/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findBetweenPrix", query = "from ActiviteTouristique where prix between :p1 and :p2")

})
/**
 *
 * @author FATI
 */


@Table(name = "activite_touristique")
public class ActiviteTouristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String lieu;
    private double prix;
    private String description;

    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;
    @OneToMany(mappedBy = "activite")
    private List<ReservationActivity> reservations;

    public ActiviteTouristique() {
    }

    public ActiviteTouristique(String nom, String lieu, double prix, String description, Guide guide) {
        this.nom = nom;
        this.lieu = lieu;
        this.prix = prix;
        this.description = description;
        this.guide = guide;
    }

 
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public List<ReservationActivity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationActivity> reservations) {
        this.reservations = reservations;
    }

}
