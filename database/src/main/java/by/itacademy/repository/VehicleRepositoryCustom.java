package by.itacademy.repository;

import by.itacademy.dto.VehicleDto;
import by.itacademy.entity.Vehicle;

import java.util.List;

public interface VehicleRepositoryCustom {

    List<Object[]> getModelManufactureYearStandardCostMainImgRandomVehicles(int countOfRows);

    Long checkCount(VehicleDto vehicleDtoDto);

    List<Vehicle> findByParams(VehicleDto vehicleDtoDto);
}
