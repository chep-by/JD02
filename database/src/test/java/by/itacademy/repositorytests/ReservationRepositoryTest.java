package by.itacademy.repositorytests;

import by.itacademy.entity.Reservation;
import by.itacademy.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void findAllByUserLoginTest() {
        List<Reservation> allByReservationStatusStatusName = reservationRepository.findAllByReservationStatusStatusName("order created");

        Assert.assertEquals(allByReservationStatusStatusName.iterator().next().isPayed(), true);
    }


    @Test
    public void findAllNotPayedTest() {
        List<Reservation> allNotPayed = reservationRepository.findAllNotPayed();

        Assert.assertTrue(allNotPayed.isEmpty());

    }

    @Test
    public void test() {
        List<Object[]> blockedDatesByVehicleId = reservationRepository.findBlockedDatesByVehicleId(2L);
        blockedDatesByVehicleId.forEach(object -> System.out.println(object[0] + " " + object[1]));
    }
}

