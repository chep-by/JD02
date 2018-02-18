package by.itacademy;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getCarsByParams(CarDto carDto);

    Long getCount(CarDto carDto);
}
