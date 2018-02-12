package by.itacademy.entitytests;

import by.itacademy.BaseTest;
import by.itacademy.entity.AdditionalUsersInfo;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UserTest extends BaseTest {

    @Test
    public void saveUserTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Role role = new Role();
        role.setRole("admin");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        session.save(role);

        User user = new User();
        user.setLogin("1");
        user.setPassword("1");
        user.setRoles(roles);
        AdditionalUsersInfo additionalUsersInfo = new AdditionalUsersInfo();
        additionalUsersInfo.setUser(user);
        additionalUsersInfo.setDrivingLicenceInfo("123124124");
        additionalUsersInfo.setPassportInfo("1234453");
        user.setAdditionalUsersInfo(additionalUsersInfo);
        session.save(user);

        User user1 = session.get(User.class, 1L);

        Assert.assertEquals(user1.getLogin(), "1");
        Assert.assertEquals(user1.getPassword(), "1");
        Assert.assertTrue(user1.getRoles().contains(role));
        Assert.assertEquals(user1.getAdditionalUsersInfo(), additionalUsersInfo);
        transaction.commit();
        session.close();
    }

}
