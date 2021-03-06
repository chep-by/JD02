package by.itacademy.repositorytests;

import by.itacademy.entity.Vehicle;
import by.itacademy.repository.VehicleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

public class VehicleRepositoryTest extends BaseRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    public void simpleTest(){
        Iterable<Vehicle> all = vehicleRepository.findAll();
        all.forEach(System.out::println);
        System.out.println(all.iterator().next().getCubicCapacity());
    }

    @Test
    public void getModelManufactureYearStandardCostRandomSixVehiclesTest() {

        System.out.println(vehicleRepository.getModelManufactureYearStandardCostRandomSixVehicles(15L));
    }
}
