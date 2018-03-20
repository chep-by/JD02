package by.itacademy.service;

import by.itacademy.entity.AdditionalUsersInfo;

public interface AdditionalUserInfoService {
    String[] getDrivingLicenceAndPassportInfoByUsername(String username);

    void saveDrivingLicenceAndPassportInfoByUsername(String name, AdditionalUsersInfo additionalUsersInfo);
}
