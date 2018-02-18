package by.itacademy.entity;

import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@ToString
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
