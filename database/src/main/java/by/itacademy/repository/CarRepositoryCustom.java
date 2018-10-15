package by.itacademy.repository;

import by.itacademy.dto.CarDto;

import java.util.List;

public interface CarRepositoryCustom {

    Long checkCount(CarDto carDto);

    List<Car> findByParams(CarDto carDto);

}
