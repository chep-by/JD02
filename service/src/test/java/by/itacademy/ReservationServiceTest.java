package by.itacademy;

import by.itacademy.dto.DateIntervalDto;
import by.itacademy.dto.ReservationDto;
import by.itacademy.service.ReservationService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ReservationServiceTest extends BaseServiceTest {

    @Autowired
    ReservationService reservationService;

    @Test
    public void findBlockedDatesByVehicleId() {
        List<DateIntervalDto> blockedDatesByVehicleId = reservationService.findBlockedDatesByVehicleId(2L);
        Assert.assertTrue(blockedDatesByVehicleId.size() == 1);
    }

    @Test
    public void createAndSaveReservationTest() {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setDateTake(LocalDate.now().plusDays(2));
        reservationDto.setDateReturn(LocalDate.now().plusDays(4));
        reservationDto.setVehicleId(1L);
        reservationDto.setCommend("dskjhdshdfssdfkh");
        reservationDto.setUserName("alex");
        reservationService.createAndSaveReservation(reservationDto);
    }
}
