package by.itacademy.entitytests;

import by.itacademy.repository.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CarTest extends BaseEntityTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveTest() {

        Car carFind = carRepository.findOne(1L);

        Assert.assertEquals(carFind.getVehicleCategory().getCategoryName(), "luxury");
        Assert.assertEquals(carFind.getManufacture(), "BMW");
    }

}
