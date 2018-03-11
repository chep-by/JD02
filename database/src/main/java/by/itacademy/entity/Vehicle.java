package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private VehicleCategory vehicleCategory;

    @Column(name = "manufacture", nullable = false)
    private String manufacture;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "cubic_capacity", nullable = false)
    private int cubicCapacity;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "power_", nullable = false)
    private int power;

    @Column(name = "stanadart_price", nullable = false)
    private int standardPrice;

    @OneToMany(mappedBy = "vehicle", orphanRemoval = true)
    private List<Photos> photos;

}
