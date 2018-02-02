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
@Table(name = "manufactures")
public class Manufacture extends BaseEntity {

    @Column(name = "manufacture_name")
    private String manufactureName;
}
