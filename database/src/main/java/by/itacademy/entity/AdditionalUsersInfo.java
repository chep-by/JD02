package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "additional_users_info")
public class AdditionalUsersInfo extends BaseEntity {

    @Column(name = "passport_info")
    private String passportInfo;

    @Column(name = "driving_licence_info")
    private String drivingLicenceInfo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
