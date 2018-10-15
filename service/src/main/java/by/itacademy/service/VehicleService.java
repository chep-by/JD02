package by.itacademy.service;

import by.itacademy.dto.VehicleDto;

import java.util.List;
import java.util.Map;

public interface VehicleService {

    Long countOfVehicles();

    List<Object[]> getModelManufactureYearStandardCostMainImgRandomVehicles(int countOfRows);

    Vehicle findOne(Long id);

    void prepareAndSaveOrUpdateVehicle(Vehicle vehicle, String[] photoUrl, int main, String categoryName);

    List<Vehicle> getVehiclesByParams(VehicleDto vehicleDto);

    Long getCount(VehicleDto vehicleDto);

    List<String> getAllManufactures();

    List<String> getAllModelsByManufacture(String manufacture);

    int getCountOfPages(VehicleDto vehicleDto);

    Map<String, List<String>> getMapManufactureModels();
}
