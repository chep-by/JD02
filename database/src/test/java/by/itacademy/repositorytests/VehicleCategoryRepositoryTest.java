package by.itacademy.repositorytests;

import by.itacademy.repository.VehicleCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleCategoryRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Test
    public void findAllCategoriesNamesTest() {
        List<String> allCategoriesNames = vehicleCategoryRepository.findAllCategoriesNames();
        Assert.assertTrue(allCategoriesNames.size() == 4);
    }

    @Test
    public void findVehicleCategoryByCategoryNameTest() {
        VehicleCategory luxury = vehicleCategoryRepository.findVehicleCategoryByCategoryName("luxury");
        System.out.println(luxury);
        Assert.assertTrue(luxury.getCategoryName().equals("luxury"));
    }
}
