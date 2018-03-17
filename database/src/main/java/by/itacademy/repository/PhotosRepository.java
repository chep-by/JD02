package by.itacademy.repository;

import by.itacademy.entity.Photos;
import by.itacademy.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photos, Long> {

    void deletePhotosByVehicle(Vehicle vehicle);
}
