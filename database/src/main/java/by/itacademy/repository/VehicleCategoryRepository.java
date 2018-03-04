package by.itacademy.repository;

import by.itacademy.entity.VehicleCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleCategoryRepository extends CrudRepository<VehicleCategory, Long> {

    @Query(value = "select vc.categoryName from VehicleCategory vc")
    List<String> findAllCategoriesNames();
}
