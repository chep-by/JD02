package by.itacademy.repository;

import org.springframework.data.repository.CrudRepository;

public interface ReservationStatusRepository extends CrudRepository<ReservationStatus, Long> {

    ReservationStatus findByStatusName(String statusName);
}
