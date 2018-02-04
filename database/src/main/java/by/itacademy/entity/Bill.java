package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class Bill extends BaseEntity {

    @Column(name = "pay_datetime")
    private LocalDateTime payDateTime;

    @Column(name = "final_cost", nullable = false)
    private int finalCost;

    @OneToOne(mappedBy = "bill")
    private Reservation reservation;
}
