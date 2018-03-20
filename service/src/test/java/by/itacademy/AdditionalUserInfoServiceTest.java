package by.itacademy;

import by.itacademy.entity.AdditionalUsersInfo;
import by.itacademy.service.AdditionalUserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalUserInfoServiceTest extends BaseServiceTest {

    @Autowired
    AdditionalUserInfoService additionalUserInfoService;

    @Test
    public void getDrivingLicenceAndPassportInfoByUsernameReturnStringTest(){
        String[] alexInfo = additionalUserInfoService.getDrivingLicenceAndPassportInfoByUsername("alex");
        Assert.assertEquals(alexInfo[0], "passport_alex");
        Assert.assertEquals(alexInfo[1], "licence_alex");
    }

    @Test
    public void getDrivingLicenceAndPassportInfoByUsernameReturnNullTest() {
        String[] alexInfo = additionalUserInfoService.getDrivingLicenceAndPassportInfoByUsername("gsdg");
        Assert.assertTrue(alexInfo == null);
    }

    @Test
    public void saveDrivingLicenceAndPassportInfoByUsernameTest() {
        AdditionalUsersInfo additionalUsersInfo = new AdditionalUsersInfo();
        additionalUsersInfo.setDrivingLicenceInfo("dr");
        additionalUsersInfo.setPassportInfo("pas");
        additionalUserInfoService.saveDrivingLicenceAndPassportInfoByUsername("lex", additionalUsersInfo);
    }
}
