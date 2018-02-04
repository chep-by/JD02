package by.itacademy;

import by.itacademy.entity.Bill;
import by.itacademy.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class BillTest extends BaseTest {

    @Test
    public void saveBillTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();


        Bill bill = new Bill();
        bill.setFinalCost(15);
        bill.setPayDateTime(LocalDateTime.now());

        session.save(bill);

        Bill findBill = session.get(Bill.class, 1L);

        Assert.assertEquals(findBill.getFinalCost(), 15);

        transaction.commit();
        session.close();
    }
}
