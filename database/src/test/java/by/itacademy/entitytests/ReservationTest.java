package by.itacademy.entitytests;

import by.itacademy.entity.Reservation;
import by.itacademy.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationTest extends BaseEntityTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void saveTest() {

        Reservation reservationFind = reservationRepository.findOne(1L);

        Assert.assertTrue(reservationFind.isPayed());

    }

}
