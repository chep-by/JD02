package by.itacademy.entity;

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
    @JoinColumn(name = "category_id")
    private CarCategory carCategory;
    
    @ManyToOne
    @JoinColumn(name = "manufacture")
    private Manufacture manufacture;
    
    @ManyToOne
    @JoinColumn(name = "model")
    private Model model;
    
    @Column(name = "cubic_capacity")
    private int cubicCapacity;
    
    @Column(name = "year")
    private int year;
    
    @Column(name = "power")
    private int power;
    
    @Column(name = "stanadart_price")
    private int standardPrice;
}
