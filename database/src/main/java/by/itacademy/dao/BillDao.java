package by.itacademy.dao;

import by.itacademy.entity.Bill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class BillDao extends BaseDao<Bill> {

    public BillDao() {
        super(Bill.class);
    }

    public Bill findByReservationId(Long id) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Bill result = session.createQuery("select b from Bill b where b.reservation.id=:id", Bill.class)
                .setParameter("id", id)
                .getSingleResult();

        transaction.commit();
        session.close();
        return result;
    }

    public int calcSumBillByDate(LocalDateTime before, LocalDateTime after) {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Integer sum = session.createQuery("select sum(b.finalCost) from Bill b where b.payDateTime>:before and b.payDateTime<:after", Integer.class)
                .setParameter("before", before)
                .setParameter("after", after)
                .getSingleResult();

        transaction.commit();
        session.close();

        return sum;
    }
}
