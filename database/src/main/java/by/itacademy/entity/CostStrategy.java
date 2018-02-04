package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cost_strategies")
public class CostStrategy extends BaseEntity {

    @Column(name = "strategy", nullable = false)
    private String strategy;
}
