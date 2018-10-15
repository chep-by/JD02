package by.itacademy.service;

import java.util.List;

public interface ReservationStatusService {

    ReservationStatus getReservationStatusByStatusName(String statusName);

    List<ReservationStatus> findAll();
}
