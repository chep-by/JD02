package by.itacademy.entitytests;

import by.itacademy.entity.CostStrategy;
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

        Assert.assertEquals(findCostStrategy.getStrategy(), "1-100__3-95__5-90");
    }

}
