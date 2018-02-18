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
        List<Reservation> allByReservationStatusStatusName = reservationRepository.findAllByReservationStatusStatusName("in rent");

        Assert.assertEquals(allByReservationStatusStatusName.iterator().next().isPayed(), true);
    }

    @Test
    public void findAllByReservationStatusStatusNameTest() {
        List<Reservation> allByUserLogin = reservationRepository.findAllByUserLogin("max");

        Assert.assertEquals(allByUserLogin.iterator().next().getUser().getLogin(), "max");
    }

    @Test
    public void findAllNotPayedTest() {
        List<Reservation> allNotPayed = reservationRepository.findAllNotPayed();

        Assert.assertTrue(allNotPayed.isEmpty());

    }
}

