package by.itacademy.service;

import by.itacademy.entity.ReservationStatus;

import java.util.List;

public interface ReservationStatusService {

    ReservationStatus getReservationStatusByStatusName(String statusName);

    List<ReservationStatus> findAll();
}
