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
@Table(name = "extra_users_info")
public class ExtraUsersInfo extends BaseEntity {

    @Column(name = "passport_info")
    private String passportInfo;

    @Column(name = "driving_licence_info")
    private String drivingLicenceInfo;
}
