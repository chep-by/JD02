package by.itacademy.service;

import by.itacademy.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Long countOfVehicles();

    List<Object[]> getModelManufactureYearStandardCostMainImgRandomVehicles(int countOfRows);

    Vehicle findOne(Long id);

    void prepareAndSaveOrUpdateVehicle(Vehicle vehicle, String[] photoUrl, int main, String categoryName);
}
