package by.itacademy.repository;

import by.itacademy.dto.VehicleDto;

import java.util.List;

public interface VehicleRepositoryCustom {

    List<Object[]> getModelManufactureYearStandardCostMainImgRandomVehicles(int countOfRows);

    Long checkCount(VehicleDto vehicleDtoDto);

    List<Vehicle> findByParams(VehicleDto vehicleDtoDto);
}
