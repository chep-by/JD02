package by.itacademy;

import by.itacademy.entity.*;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ReservationTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        session.save(costStrategy);

        // Vehicle
        VehicleCategory luxury = new VehicleCategory();
        luxury.setCategoryName("Premium");
        luxury.setCostStrategy(costStrategy);
        session.save(luxury);
        Car car = new Car();
        car.setVehicleCategory(luxury);
        car.setCubicCapacity(4500);
        car.setManufacture("BMW");
        car.setModel("645");
        car.setPower(330);
        car.setStandardPrice(100);
        car.setYear(2007);
        car.setFuelType(FuelType.PETROL);
        car.setGearbox(Gearbox.SEMI_AUTOMATIC);
        car.setTransmission(Transmission.REAR_WHEEL);
        session.save(car);

        //User
        Role role = new Role();
        role.setRole("admin");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        session.save(role);

        User user = new User();
        user.setLogin("1");
        user.setPassword("1");
        user.setRoles(roles);
        AdditionalUsersInfo additionalUsersInfo = new AdditionalUsersInfo();
        additionalUsersInfo.setUser(user);
        additionalUsersInfo.setDrivingLicenceInfo("123124124");
        additionalUsersInfo.setPassportInfo("1234453");
        user.setAdditionalUsersInfo(additionalUsersInfo);
        session.save(user);

        //Reservation status
        ReservationStatus reservationStatus = new ReservationStatus();
        reservationStatus.setStatusName("in rent");
        session.save(reservationStatus);

        //Bill
        Bill bill = new Bill();
        bill.setFinalCost(15);
        bill.setPayDateTime(LocalDateTime.now());
        session.save(bill);

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setBill(bill);
        reservation.setPayed(false);
        reservation.setReservationStatus(reservationStatus);
        reservation.setVehicle(car);

        session.save(reservation);

        Reservation reservationFind = session.get(Reservation.class, 1L);

        Assert.assertEquals(reservationFind.getUser().getLogin(), "1");
        Assert.assertEquals(reservationFind.getBill().getFinalCost(), 15);
        Assert.assertEquals(reservationFind.getReservationStatus().getStatusName(), "in rent");
        Assert.assertEquals(reservationFind.getVehicle().getPower(), 330);
        Assert.assertFalse(reservationFind.isPayed());

        transaction.commit();
        session.close();
    }

}
