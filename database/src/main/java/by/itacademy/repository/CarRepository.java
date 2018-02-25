package by.itacademy.repository;

import by.itacademy.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long>, CarRepositoryCustom {

}
