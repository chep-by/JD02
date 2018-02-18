package by.itacademy;

import by.itacademy.config.ServiceConfiguration;
import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
public class CarServiceImplTest {

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
}
