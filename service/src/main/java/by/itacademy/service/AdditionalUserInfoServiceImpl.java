package by.itacademy.service;

import by.itacademy.aspect.SaveOrUpdateLogger;
import by.itacademy.entity.AdditionalUsersInfo;
import by.itacademy.entity.User;
import by.itacademy.repository.AdditionalUserInfoRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdditionalUserInfoServiceImpl implements AdditionalUserInfoService {

    private AdditionalUserInfoRepository additionalUserInfoRepository;
    private UserRepository userRepository;

    @Autowired
    public AdditionalUserInfoServiceImpl(AdditionalUserInfoRepository additionalUserInfoRepository, UserRepository userRepository) {
        this.additionalUserInfoRepository = additionalUserInfoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String[] getDrivingLicenceAndPassportInfoByUsername(String username) {
        Object[] info = additionalUserInfoRepository.getDrivingLicenceAndPassportInfoByUsername(username);
        if (info.length > 0) {
            String[] strings = new String[2];
            Object[] obj = (Object[]) info[0];
            strings[0] = String.valueOf(obj[0]);
            strings[1] = String.valueOf(obj[1]);
            return strings;
        } else {
            return null;
        }
    }

    @SaveOrUpdateLogger
    @Override
    public void saveDrivingLicenceAndPassportInfoByUsername(String name, AdditionalUsersInfo additionalUsersInfo) {
        User user = userRepository.findByLogin(name);
        additionalUsersInfo.setUser(user);
        additionalUserInfoRepository.save(additionalUsersInfo);
    }
}
