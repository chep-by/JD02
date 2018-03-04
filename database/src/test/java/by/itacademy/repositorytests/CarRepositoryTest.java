package by.itacademy.repositorytests;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import by.itacademy.repository.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarRepositoryTest extends BaseRepositoryTest{

    @Autowired
    private CarRepository carRepository;

    @Test
    public void checkCountTest() {
        CarDto carDto = new CarDto();
        carDto.setManufacture("BMW");
        carDto.setModel("645");
        carDto.setYearMin(1980);
        carDto.setYearMax(2018);
        Long aLong = carRepository.checkCount(carDto);

        Assert.assertTrue(aLong == 7L);

    }

    @Test
    public void findByParamsTest() {
        CarDto carDto = new CarDto();
        carDto.setManufacture("BMW");
        carDto.setModel("645");
        carDto.setYearMin(1980);
        carDto.setYearMax(2018);
        carDto.setPage(1);
        carDto.setPerPage(3);
        List<Car> carList = carRepository.findByParams(carDto);

        Assert.assertEquals(carList.size(), 3);

    }

    @Test
    public void findAllManufacturesTest() {
        List<String> allManufactures = carRepository.findAllManufactures();

        Assert.assertEquals(allManufactures.size(), 2);
    }

    @Test
    public void findAllModelsByManufacture() {
        List<String> bmw = carRepository.findAllModelsByManufacture("BMW");

        Assert.assertEquals(bmw.size(), 3);
    }
}
