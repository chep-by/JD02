package by.itacademy;

import by.itacademy.service.BillService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BillServiceTest extends BaseServiceTest {

    @Autowired
    BillService billService;

    @Test
    public void createAndSaveBillTest() {
        Bill bill = billService.createAndSaveBill(20);
        Assert.assertTrue(bill.getId() != 0L);
    }
}
