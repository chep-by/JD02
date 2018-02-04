package by.itacademy;

import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.VehicleCategory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class VehicleCategoryTest extends BaseTest {

    @Test
    public void saveVehicleCategoryTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        session.save(costStrategy);

        VehicleCategory vehicleCategory = new VehicleCategory();
        vehicleCategory.setCategoryName("Premium");
        vehicleCategory.setCostStrategy(costStrategy);

        session.save(vehicleCategory);

        VehicleCategory vehicleCategory1 = session.get(VehicleCategory.class, 1L);

        Assert.assertEquals(vehicleCategory1.getCategoryName(), "Premium");
        Assert.assertEquals(vehicleCategory.getCostStrategy().getStrategy(), "our strategy");

        transaction.commit();
        session.close();
    }
}
