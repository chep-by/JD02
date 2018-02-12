package by.itacademy.entitytests;

import by.itacademy.BaseTest;
import by.itacademy.entity.ReservationStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class ReservationStatusTest extends BaseTest {

    @Test
    public void saveReservationStatusTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ReservationStatus reservationStatus = new ReservationStatus();
        reservationStatus.setStatusName("in rent");

        session.save(reservationStatus);

        ReservationStatus reservationStatus1 = session.get(ReservationStatus.class, 1L);
        Assert.assertEquals(reservationStatus1.getStatusName(), "in rent");

        transaction.commit();
        session.close();
    }

}
