package by.itacademy.entitytests;

import by.itacademy.entity.VehicleCategory;
import by.itacademy.repository.VehicleCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleCategoryTest extends BaseEntityTest {

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Test
    public void saveVehicleCategoryTest() {

        VehicleCategory vehicleCategory1 = vehicleCategoryRepository.findOne(1L);

        Assert.assertEquals(vehicleCategory1.getCategoryName(), "business");
    }
}
