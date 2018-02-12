package by.itacademy.entitytests;

import by.itacademy.BaseTest;
import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.Vehicle;
import by.itacademy.entity.VehicleCategory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class VehicleTest extends BaseTest {

    @Test
    public void saveVehicleTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        session.save(costStrategy);

        VehicleCategory luxury = new VehicleCategory();
        luxury.setCategoryName("Premium");
        luxury.setCostStrategy(costStrategy);
        session.save(luxury);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleCategory(luxury);
        vehicle.setCubicCapacity(4500);
        vehicle.setManufacture("BMW");
        vehicle.setModel("645");
        vehicle.setPower(330);
        vehicle.setStandardPrice(100);
        vehicle.setYear(2007);

        session.save(vehicle);

        Vehicle vehicleFind = session.get(Vehicle.class, 1L);

        Assert.assertEquals(vehicleFind.getVehicleCategory().getCategoryName(), "Premium");

        transaction.commit();
        session.close();
    }

}
