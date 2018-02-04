package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehicle_categories")
public class VehicleCategory extends BaseEntity {

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @OneToOne
    @JoinColumn(name = "category_cost_strategy_id", nullable = false, unique = true)
    private CostStrategy costStrategy;

}
