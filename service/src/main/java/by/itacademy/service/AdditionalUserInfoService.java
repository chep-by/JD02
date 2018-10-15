package by.itacademy.service;

public interface AdditionalUserInfoService {
    String[] getDrivingLicenceAndPassportInfoByUsername(String username);

    void saveDrivingLicenceAndPassportInfoByUsername(String name, AdditionalUsersInfo additionalUsersInfo);
}
