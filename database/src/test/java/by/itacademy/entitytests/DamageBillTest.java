package by.itacademy.entitytests;

import by.itacademy.BaseTest;
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

public class DamageBillTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        //Reservation save
        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        session.save(costStrategy);

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

        ReservationStatus reservationStatus = new ReservationStatus();
        reservationStatus.setStatusName("in rent");
        session.save(reservationStatus);

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

        DamageBill damageBill = new DamageBill();
        damageBill.setCost(250);
        damageBill.setReservation(reservation);
        damageBill.setCommend("Damaged door");

        session.save(damageBill);

        DamageBill damageBillFind = session.get(DamageBill.class, 1L);

        Assert.assertEquals(damageBillFind.getCommend(), "Damaged door");
        Assert.assertEquals(damageBillFind.getCost(), 250);
        Assert.assertEquals(damageBillFind.getReservation().getVehicle(), car);


        transaction.commit();
        session.close();
    }

}
