package by.itacademy;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;

import java.util.List;

public class CarService {

    public List<Car> getCarsByParams(CarDto carDto) {
        return new CarDao().findByParams(carDto);
    }

    public Long getCount(CarDto carDto) {
        return new CarDao().checkCount(carDto);
    }
}
