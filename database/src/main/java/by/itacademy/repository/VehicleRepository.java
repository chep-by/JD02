package by.itacademy.repository;

import by.itacademy.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long>, VehicleRepositoryCustom {

//    @Query(value = "select v.model, v.manufacture, v.standardPrice, v.year from Vehicle v order by RAND() LIMIT 0,6")
//    List<Object[]> getModelManufactureYearStandardCostRandomSixVehicles();

}
