package by.itacademy;

import by.itacademy.dto.CostStrategyDao;
import by.itacademy.service.CostStrategyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CostStrategyServiceTest extends BaseServiceTest {

    @Autowired
    CostStrategyService costStrategyService;

    @Test
    public void decodeCostStrategyTest() {
        List<CostStrategyDao> costStrategyDaos = costStrategyService.decodeCostStrategy("1-2=100_3-4=95_5-10=90");
        Assert.assertTrue(costStrategyDaos.size() == 3);
    }

    @Test
    public void encodeCostStrategyTest() {
        String s = costStrategyService.encodeCostStrategy(costStrategyService.decodeCostStrategy("1-2=100_3-4=95_5-10=90"));
        Assert.assertTrue(s.equals("1-2=100_3-4=95_5-10=90"));
    }
}
