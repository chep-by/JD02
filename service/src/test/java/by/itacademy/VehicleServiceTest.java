package by.itacademy;

import by.itacademy.entity.Vehicle;
import by.itacademy.service.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class VehicleServiceTest extends BaseServiceTest {

    @Autowired
    private VehicleService vehicleService;

    @Test
    public void simpleTest() {
        System.out.println(vehicleService.findOne(52L));
    }

    @Test
    public void prepareAndSaveOrUpdateVehicleTest() {
        Vehicle one = vehicleService.findOne(1L);
        String[] strings = new String[4];
        strings[0] = "https://pp.userapi.com/c846323/v846323990/453b/hSGFd77ApJQ.jpg";
        strings[1] = "https://pp.userapi.com/c846323/v846323990/4544/KSck6JsKO1A.jpg";
        strings[2] = "https://pp.userapi.com/c846323/v846323990/454d/sT-61th0enI.jpg";
        strings[3] = "https://pp.userapi.com/c846323/v846323990/4556/da4z9djpw94.jpg";
        vehicleService.prepareAndSaveOrUpdateVehicle(one, strings, 0, "luxury");
    }

    @Test
    public void  getMapManufactureModelsTest() {
        Map<String, List<String>> mapManufactureModels = vehicleService.getMapManufactureModels();
        Assert.assertTrue(mapManufactureModels.size() == 8);
    }
}
