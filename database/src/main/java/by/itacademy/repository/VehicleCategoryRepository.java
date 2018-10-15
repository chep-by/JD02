package by.itacademy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleCategoryRepository extends CrudRepository<VehicleCategory, Long> {

    @Query(value = "select vc.categoryName from VehicleCategory vc")
    List<String> findAllCategoriesNames();

    VehicleCategory findVehicleCategoryByCategoryName(String categoryName);
}
