package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity {

    @Column(name = "datetime_take")
    private LocalDateTime dateTimeTake;

    @Column(name = "datetime_return")
    private LocalDateTime dateTimeReturn;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private ReservationStatus reservationStatus;

    @Column(name = "commend")
    private String commend;

    @Column(name = "is_payed", nullable = false)
    private boolean isPayed;

    @OneToOne
    @JoinColumn(name = "bill_id", nullable = false, unique = true)
    private Bill bill;

    @OneToOne(mappedBy = "reservation")
    private DamageBill damageBill;

}
