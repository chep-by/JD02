package by.itacademy;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import by.itacademy.service.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarServiceImplTest extends BaseServiceTest{

    @Autowired
    private CarService carService;

    @Test
    public void getCarsByParamsTest() {
        CarDto carDto = new CarDto();
        carDto.setManufacture("BMW");
        carDto.setModel("645");
        carDto.setYearMin(1980);
        carDto.setYearMax(2018);
        carDto.setPage(1);
        carDto.setPerPage(3);
        List<Car> carList = carService.getCarsByParams(carDto);

        Assert.assertEquals(carList.size(), 3);
    }

    @Test
    public void getCountTest() {
        CarDto carDto = new CarDto();
        carDto.setManufacture("BMW");
        carDto.setModel("645");
        carDto.setYearMin(1980);
        carDto.setYearMax(2018);
        Long aLong = carService.getCount(carDto);

        Assert.assertTrue(aLong == 7L);

    }

    @Test
    public void getAllManufacturesTest() {
        List<String> allManufactures = carService.getAllManufactures();

        Assert.assertEquals(allManufactures.size(), 2);
    }

    @Test
    public void getMapManufactureModelsTest() {
        Map<String, List<String>> manufactureModelsMap = new HashMap<>();
        List<String> allManufactures = carService.getAllManufactures();
        allManufactures
                .forEach(manufacture -> manufactureModelsMap.put(manufacture, carService.getAllModelsByManufacture(manufacture)));
        Assert.assertTrue(manufactureModelsMap.size() == 2);

    }
}
