package by.itacademy;

import by.itacademy.entity.Car;
import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.VehicleCategory;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class CarTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

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

        Car carFind = session.get(Car.class, 1L);

        Assert.assertEquals(carFind.getVehicleCategory().getCategoryName(), "Premium");
        Assert.assertEquals(carFind.getManufacture(), "BMW");

        transaction.commit();
        session.close();
    }

}
