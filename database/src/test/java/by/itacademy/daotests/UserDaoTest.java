package by.itacademy.daotests;

import by.itacademy.dao.UserDao;
import by.itacademy.entity.Car;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void findByLoginTest() {

        User user = new User();
        user.setLogin("1");
        user.setPassword("1");

        UserDao userDao = new UserDao();
        userDao.save(user);

        User byLogin = userDao.findByLogin("1");

        Assert.assertEquals("1", byLogin.getLogin());
    }

}
