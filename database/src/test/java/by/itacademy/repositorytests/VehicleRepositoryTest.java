package by.itacademy.repositorytests;

import by.itacademy.dto.VehicleDto;
import by.itacademy.repository.VehicleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleRepositoryTest extends BaseRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    public void simpleTest() {
        Iterable<Vehicle> all = vehicleRepository.findAll();
        all.forEach(System.out::println);
        System.out.println(all.iterator().next().getCubicCapacity());
    }

    @Test
    public void getModelManufactureYearStandardCostRandomSixVehiclesTest() {

        System.out.println(vehicleRepository.getModelManufactureYearStandardCostMainImgRandomVehicles(6));
    }

    @Test
    public void findAllManufacturesTest() {
        List<String> allManufactures = vehicleRepository.findAllManufactures();

        Assert.assertEquals(allManufactures.size(), 8);
    }

    @Test
    public void findAllModelsByManufacture() {
        List<String> bmw = vehicleRepository.findAllModelsByManufacture("BMW");

        Assert.assertEquals(bmw.size(), 5);
    }

    @Test
    public void findByParamsTest() {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setManufacture("BMW");
        vehicleDto.setPage(1);
        vehicleDto.setPerPage(5);
        List<Vehicle> list = vehicleRepository.findByParams(vehicleDto);
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void checkCount() {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setManufacture("BMW");
        vehicleDto.setPage(1);
        vehicleDto.setPerPage(3);
        List<Vehicle> list = vehicleRepository.findByParams(vehicleDto);
        Assert.assertEquals(list.size(), 3);
    }
}
