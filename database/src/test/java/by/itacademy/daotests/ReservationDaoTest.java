package by.itacademy.daotests;

import by.itacademy.dao.BillDao;
import by.itacademy.dao.CarDao;
import by.itacademy.dao.CostStrategyDao;
import by.itacademy.dao.ReservationDao;
import by.itacademy.dao.ReservationStatusDao;
import by.itacademy.dao.RoleDao;
import by.itacademy.dao.UserDao;
import by.itacademy.dao.VehicleCategoryDao;
import by.itacademy.entity.AdditionalUsersInfo;
import by.itacademy.entity.Bill;
import by.itacademy.entity.Car;
import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.Reservation;
import by.itacademy.entity.ReservationStatus;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import by.itacademy.entity.VehicleCategory;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReservationDaoTest {

    @Test
    public void customQueryTest() {

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        new CostStrategyDao().save(costStrategy);

        // Vehicle
        VehicleCategory luxury = new VehicleCategory();
        luxury.setCategoryName("Premium");
        luxury.setCostStrategy(costStrategy);
        new VehicleCategoryDao().save(luxury);
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
        new CarDao().save(car);

        //User
        Role role = new Role();
        role.setRole("admin");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        new RoleDao().save(role);

        User user = new User();
        user.setLogin("1");
        user.setPassword("1");
        user.setRoles(roles);
        AdditionalUsersInfo additionalUsersInfo = new AdditionalUsersInfo();
        additionalUsersInfo.setUser(user);
        additionalUsersInfo.setDrivingLicenceInfo("123124124");
        additionalUsersInfo.setPassportInfo("1234453");
        user.setAdditionalUsersInfo(additionalUsersInfo);
        new UserDao().save(user);

        //Reservation status
        ReservationStatus reservationStatus = new ReservationStatus();
        reservationStatus.setStatusName("in rent");
        ReservationStatus reservationStatus1 = new ReservationStatus();
        reservationStatus1.setStatusName("ended");

        ReservationStatusDao reservationStatusDao = new ReservationStatusDao();
        reservationStatusDao.save(reservationStatus);
        reservationStatusDao.save(reservationStatus1);

        //Bill
        Bill bill = new Bill();
        bill.setFinalCost(15);
        bill.setPayDateTime(LocalDateTime.now());
        Bill bill1 = new Bill();
        bill.setFinalCost(15);
        bill.setPayDateTime(LocalDateTime.now());
        BillDao billDao = new BillDao();
        billDao.save(bill);
        billDao.save(bill1);

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setBill(bill);
        reservation.setPayed(true);
        reservation.setReservationStatus(reservationStatus1);
        reservation.setVehicle(car);

        Reservation reservation1 = new Reservation();
        reservation1.setUser(user);
        reservation1.setBill(bill1);
        reservation1.setPayed(false);
        reservation1.setReservationStatus(reservationStatus);
        reservation1.setVehicle(car);

        ReservationDao reservationDao = new ReservationDao();
        reservationDao.save(reservation);
        reservationDao.save(reservation1);

        List<Reservation> reservationsByUserLogin = reservationDao.findReservationsByUserLogin("1");
        Assert.assertEquals(reservationsByUserLogin.size(), 2);

        List<Reservation> notPayedReservations = reservationDao.findNotPayedReservations();
        Assert.assertEquals(notPayedReservations.size(), 1);

        List<Reservation> reservationsWithStatus = reservationDao.findReservationsWithStatus(reservationStatus);
        Assert.assertEquals(reservationsWithStatus.size(), 1);

    }
}
