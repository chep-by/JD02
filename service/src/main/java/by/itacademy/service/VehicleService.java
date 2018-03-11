package by.itacademy.service;

import by.itacademy.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Long countOfVehicles();

    List<Object[]> getModelManufactureYearStandardCostRandomSixVehicles();

    Vehicle findOne(Long id);
}
