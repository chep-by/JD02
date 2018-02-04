package by.itacademy;

import by.itacademy.entity.CostStrategy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class CostStrategyTest extends BaseTest {

    @Test
    public void saveCostStrategyTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");

        session.save(costStrategy);

        CostStrategy findCostStrategy = session.get(CostStrategy.class, 1L);

        Assert.assertEquals(findCostStrategy.getStrategy(), "our strategy");


        transaction.commit();
        session.close();
    }

}
