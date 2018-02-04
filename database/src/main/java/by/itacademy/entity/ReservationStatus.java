package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation_statuses")
public class ReservationStatus extends BaseEntity {

    @Column(name = "status_name", nullable = false, unique = true)
    private String statusName;

    @OneToMany(mappedBy = "reservationStatus")
    private Set<Reservation> reservations;

}
