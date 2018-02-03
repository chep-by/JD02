package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "additional_reviews")
public class AdditionalReview extends BaseEntity {

    private Commend commend;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
