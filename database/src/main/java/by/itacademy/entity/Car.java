package by.itacademy.entity;

import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends Vehicle {

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission", nullable = false)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(name = "gearbox", nullable = false)
    private Gearbox gearbox;

}
