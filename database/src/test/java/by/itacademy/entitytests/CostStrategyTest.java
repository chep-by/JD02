package by.itacademy.entitytests;

import by.itacademy.repository.CostStrategyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CostStrategyTest extends BaseEntityTest {

    @Autowired
    private CostStrategyRepository costStrategyRepository;

    @Test
    public void saveCostStrategyTest() {

        CostStrategy findCostStrategy = costStrategyRepository.findOne(1L);

        Assert.assertEquals(findCostStrategy.getStrategy(), "1-2=100_3-4=95_5-10=90");
    }

}
