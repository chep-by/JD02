package by.itacademy;

import by.itacademy.service.VehicleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleServiceTest extends BaseServiceTest {

    @Autowired
    private VehicleService vehicleService;

    @Test
    public void simpleTest() {
        System.out.println(vehicleService.findOne(52L));

    }
}
