/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author FATI
 */
@Entity
@NamedQueries({  
    @NamedQuery(name = "findByEmail", query = "from Touriste where email = :email")
})
public class Touriste extends User {
   
   @OneToMany(mappedBy = "touriste")
private List<ReservationActivity> reservations;

    public Touriste() {
    }

    public Touriste(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

    
    public List<ReservationActivity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationActivity> reservations) {
        this.reservations = reservations;
    }
    
    
}
