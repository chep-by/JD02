package by.itacademy.repository;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;

import java.util.List;

public interface CarRepositoryCustom {

    Long checkCount(CarDto carDto);

    List<Car> findByParams(CarDto carDto);

}
