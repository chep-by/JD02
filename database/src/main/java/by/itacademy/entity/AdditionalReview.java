package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "additional_reviews")
public class AdditionalReview extends BaseEntity {

    private Commend commend;

    @OneToOne
    @JoinColumn(name = "review_id", nullable = false, unique = true)
    private Review review;
}
