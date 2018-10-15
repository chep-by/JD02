package by.itacademy.repository;

import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photos, Long> {

    void deletePhotosByVehicle(Vehicle vehicle);
}
