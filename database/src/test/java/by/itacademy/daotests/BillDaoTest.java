package by.itacademy.daotests;

import by.itacademy.dao.BillDao;
import by.itacademy.dao.ReservationDao;
import by.itacademy.entity.Bill;
import by.itacademy.entity.Reservation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class BillDaoTest {

    @Test
    public void findByReservationIdTest() {
        Reservation reservation = new Reservation();
        Long reservationId = new ReservationDao().save(reservation);

        Bill bill = new Bill();
        bill.setFinalCost(15);
        bill.setPayDateTime(LocalDateTime.now());
        bill.setReservation(reservation);

        BillDao billDao = new BillDao();

        billDao.save(bill);

        Bill byReservationId = billDao.findByReservationId(reservationId);
        Assert.assertEquals(15, byReservationId.getFinalCost());
    }
}
