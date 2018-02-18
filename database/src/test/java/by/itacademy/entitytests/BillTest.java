package by.itacademy.entitytests;

import by.itacademy.entity.Bill;
import by.itacademy.repository.BillRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BillTest extends BaseEntityTest {

    @Autowired
    private BillRepository billRepository;

    @Test
    public void saveBillTest() {

        Bill findBill = billRepository.findOne(1L);

        Assert.assertEquals(findBill.getFinalCost(), 100);

    }
}
