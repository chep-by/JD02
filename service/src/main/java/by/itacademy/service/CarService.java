package by.itacademy.service;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    List<Car> getCarsByParams(CarDto carDto);

    Long getCount(CarDto carDto);

    List<String> getAllManufactures();

    List<String> getAllModelsByManufacture(String manufacture);

    int getCountOfPages(CarDto carDto);

    Map<String, List<String>> getMapManufactureModels();
}
