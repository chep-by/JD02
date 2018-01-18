package by.itacademy;


import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void userPlusOneTest() {
        UserService userService = new UserService();
        Assert.assertEquals(userService.userPlusOne(), 4);
    }
}
