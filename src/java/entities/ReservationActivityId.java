package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationActivityId implements Serializable {
    
    @Column(name = "activite_touriste_id")
    private int activiteId;

    @Column(name = "touriste_id")
    private int touristeId;

    public ReservationActivityId() {
    }

    public ReservationActivityId(int activiteId, int touristeId) {
        this.activiteId = activiteId;
        this.touristeId = touristeId;
    }

   

    public int getActiviteTouristiqueId() {
        return activiteId;
    }

    public void setActiviteTouristiqueId(int ActiviteTouristiqueId) {
        this.activiteId = ActiviteTouristiqueId;
    }

    public int getTouristeId() {
        return touristeId;
    }

    public void setTouristeId(int touristeId) {
        this.touristeId = touristeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReservationActivityId that = (ReservationActivityId) o;

        if (activiteId != that.activiteId) {
            return false;
        }
        return touristeId == that.touristeId;
    }

    @Override
    public int hashCode() {
        int result = activiteId;
        result = 31 * result + touristeId;
        return result;
    }

}
