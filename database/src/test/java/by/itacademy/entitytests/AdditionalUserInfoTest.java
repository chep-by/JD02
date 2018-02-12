package by.itacademy.entitytests;

import by.itacademy.BaseTest;
import by.itacademy.entity.AdditionalUsersInfo;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class AdditionalUserInfoTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setLogin("1");
        user.setPassword("1");
        session.save(user);

        AdditionalUsersInfo additionalUsersInfo = new AdditionalUsersInfo();
        additionalUsersInfo.setUser(user);
        additionalUsersInfo.setDrivingLicenceInfo("123124124");
        additionalUsersInfo.setPassportInfo("1234453");

        session.save(additionalUsersInfo);

        AdditionalUsersInfo additionalUsersInfo1 = session.get(AdditionalUsersInfo.class, 1L);

        Assert.assertEquals(additionalUsersInfo1.getUser(), user);
        Assert.assertEquals(additionalUsersInfo1.getDrivingLicenceInfo(), "123124124");
        Assert.assertEquals(additionalUsersInfo1.getPassportInfo(), "1234453");

        transaction.commit();
        session.close();
    }

}
