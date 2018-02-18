package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "additional_users_info")
public class AdditionalUsersInfo extends BaseEntity {

    @Column(name = "passport_info", nullable = false, unique = true)
    private String passportInfo;

    @Column(name = "driving_licence_info", nullable = false, unique = true)
    private String drivingLicenceInfo;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
