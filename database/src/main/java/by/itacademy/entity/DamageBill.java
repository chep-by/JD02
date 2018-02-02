package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "damage_bills")
public class DamageBill extends BaseEntity {
    
    @Column(name = "cost")
    private int cost;
    
    @Column(name = "commend")
    private String commend;
    
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
