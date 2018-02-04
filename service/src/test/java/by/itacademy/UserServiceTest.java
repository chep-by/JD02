package by.itacademy;


import by.itacademy.entity.Car;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void userPlusOneTest() {
        UserService userService = new UserService();
        Assert.assertEquals(userService.userPlusOne(), 4);
    }

    @Test
    public void getCarInfoTest() {
        Car car = new Car();
        car.setModel("BMW");

        Assert.assertEquals(new UserService().getCarInfo().substring(0,3), "BMW");

    }
}
