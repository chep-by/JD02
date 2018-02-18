package by.itacademy.entitytests;

import by.itacademy.entity.ReservationStatus;
import by.itacademy.repository.ReservationStatusRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationStatusTest extends BaseEntityTest {

    @Autowired
    private ReservationStatusRepository reservationStatusRepository;

    @Test
    public void saveReservationStatusTest() {

        ReservationStatus reservationStatus1 = reservationStatusRepository.findOne(1L);
        Assert.assertEquals(reservationStatus1.getStatusName(), "in rent");

    }

}
