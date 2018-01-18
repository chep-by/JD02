package by.itacademy;

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
}
