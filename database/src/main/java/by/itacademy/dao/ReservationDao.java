package by.itacademy.dao;

import by.itacademy.entity.Reservation;
import by.itacademy.entity.ReservationStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDao extends BaseDao<Reservation> {

    public ReservationDao() {
        super(Reservation.class);
    }

    public List<Reservation> findReservationsByUserLogin(String login) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Reservation> list = session.createQuery("select r from Reservation r where user.login=:login", Reservation.class)
                .setParameter("login", login)
                .list();

        transaction.commit();
        session.close();

        return list;
    }

    public List<Reservation> findReservationsWithStatus(ReservationStatus reservationStatus) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Reservation> list = session.createQuery("select r from Reservation r where reservationStatus=:reservationStatus", Reservation.class)
                .setParameter("reservationStatus", reservationStatus)
                .list();

        transaction.commit();
        session.close();

        return list;
    }

    public List<Reservation> findNotPayedReservations() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Reservation> list = session.createQuery("select r from Reservation r where isPayed=false ", Reservation.class)
                .list();

        transaction.commit();
        session.close();

        return list;
    }

}
