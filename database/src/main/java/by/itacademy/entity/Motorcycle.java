package by.itacademy.entity;

import by.itacademy.enums.MotorcycleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "motorcycles")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Motorcycle extends Vehicle {

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MotorcycleType motorcycleType;
}
