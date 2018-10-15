package by.itacademy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdditionalUserInfoRepository extends CrudRepository<AdditionalUsersInfo, Long> {

    @Query(value = "select a.passportInfo, a.drivingLicenceInfo from AdditionalUsersInfo a where a.user.login=?1")
    Object[] getDrivingLicenceAndPassportInfoByUsername(String username);
}
