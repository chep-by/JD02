package by.itacademy;

import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.Motorcycle;
import by.itacademy.entity.VehicleCategory;
import by.itacademy.enums.MotorcycleType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class MotorcycleTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        session.save(costStrategy);

        VehicleCategory moto = new VehicleCategory();
        moto.setCategoryName("Moto");
        moto.setCostStrategy(costStrategy);
        session.save(moto);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setMotorcycleType(MotorcycleType.SPORT);
        motorcycle.setVehicleCategory(moto);
        motorcycle.setCubicCapacity(1000);
        motorcycle.setManufacture("Yamaha");
        motorcycle.setModel("R1");
        motorcycle.setPower(150);
        motorcycle.setStandardPrice(100);
        motorcycle.setYear(2014);

        session.save(motorcycle);

        Motorcycle motorcycleFind = session.get(Motorcycle.class, 1L);

        Assert.assertEquals(motorcycleFind.getMotorcycleType(), MotorcycleType.SPORT);
        Assert.assertEquals(motorcycleFind.getModel(), "R1");

        transaction.commit();
        session.close();
    }

}
