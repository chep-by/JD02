package by.itacademy.repositorytests;

import by.itacademy.repository.AdditionalUserInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class AdditionalUserInfoRepositoryTest extends BaseRepositoryTest {

    @Autowired
    AdditionalUserInfoRepository additionalUserInfoRepository;

    @Test
    public void test() {
        Assert.assertFalse(Arrays.asList(additionalUserInfoRepository.getDrivingLicenceAndPassportInfoByUsername("alex")).isEmpty());
    }
}
