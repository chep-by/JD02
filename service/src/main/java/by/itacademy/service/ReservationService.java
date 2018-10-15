package by.itacademy.service;

import by.itacademy.dto.DateIntervalDto;
import by.itacademy.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    List<DateIntervalDto> findBlockedDatesByVehicleId(Long id);

    void createAndSaveReservation(ReservationDto reservationDto);

    List<Reservation> findAll();

    Reservation findOne(Long id);

    void updateByReservationDto(Reservation reservationLikeDtoHasIdReservationStatusPayed);

    List<Reservation> findAllByUserLogin(String login);
}
