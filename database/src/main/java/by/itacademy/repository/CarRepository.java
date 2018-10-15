package by.itacademy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long>, CarRepositoryCustom {

    @Query(value = "select c.manufacture from Car c group by c.manufacture")
    List<String> findAllManufactures();

    @Query(value = "select c.model from Car c where c.manufacture=?1 group by c.model")
    List<String> findAllModelsByManufacture(String manufacture);
}
