package by.itacademy;

import by.itacademy.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void getNumTest() {
        UserDao userDao = new UserDao();
        userDao.setNum(4);
        Assert.assertEquals(userDao.getNum(), 4);
    }

    @Test
    public void setNumTest() {
        UserDao userDao = new UserDao();
        userDao.setNum(10);
        Assert.assertEquals(userDao.getNum(), 10);
    }

    @Test
    public void getCarTest() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Car car = session.get(Car.class, 1L);

        Assert.assertEquals(car, new UserDao().getCar());

        session.close();
        sessionFactory.close();
    }
}
