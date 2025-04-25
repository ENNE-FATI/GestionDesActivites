package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "guides")
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "findGuidesWithActivities",
        query = "SELECT g.* FROM guides g " +
                "JOIN activite_touristique a ON g.id = a.guide_id",
        resultClass = Guide.class
    )
})

public class Guide extends User {

    private String langue;

    @OneToMany(mappedBy = "guide", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActiviteTouristique> activites;

    public Guide() {
    }

    public Guide(String langue, String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
        this.langue = langue;
    }

   
    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public List<ActiviteTouristique> getActivites() {
        return activites;
    }

    public void setActivites(List<ActiviteTouristique> activites) {
        this.activites = activites;
    }
}
