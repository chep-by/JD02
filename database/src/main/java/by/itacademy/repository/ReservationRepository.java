package by.itacademy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByUserLogin(String login);

    List<Reservation> findAllByReservationStatusStatusName(String statusName);

    @Query(value = "select r from Reservation r where r.isPayed=false")
    List<Reservation> findAllNotPayed();

    @Query(value = "select r.dateTake, r.dateReturn from Reservation r where r.vehicle.id=?1")
    List<Object[]> findBlockedDatesByVehicleId(Long id);

}
