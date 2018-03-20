package by.itacademy.entitytests;

import by.itacademy.entity.AdditionalUsersInfo;
import by.itacademy.repository.AdditionalUserInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalUserInfoTest extends BaseEntityTest {

    @Autowired
    private AdditionalUserInfoRepository additionalUserInfoRepository;

    @Test
    public void saveTest() {

        AdditionalUsersInfo additionalUsersInfo1 = additionalUserInfoRepository.findOne(1L);

        Assert.assertEquals(additionalUsersInfo1.getUser().getLogin(), "alex");
        Assert.assertEquals(additionalUsersInfo1.getDrivingLicenceInfo(), "licence_alex");
        Assert.assertEquals(additionalUsersInfo1.getPassportInfo(), "passport_alex");

    }

}
