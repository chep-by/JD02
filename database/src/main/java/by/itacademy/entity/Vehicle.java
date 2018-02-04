package by.itacademy.entity;

import by.itacademy.entity.BaseEntity;
import by.itacademy.entity.VehicleCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
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
}
