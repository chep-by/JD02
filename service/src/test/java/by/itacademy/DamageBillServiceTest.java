package by.itacademy;

import by.itacademy.entity.DamageBill;
import by.itacademy.service.DamageBillService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DamageBillServiceTest extends BaseServiceTest {

    @Autowired
    DamageBillService damageBillService;

    @Test
    public void saveDamageBillByBillAndReservationIdTest() {
        DamageBill damageBill = new DamageBill();
        damageBill.setCommend("asdasd");
        damageBill.setCost(70);
        damageBillService.saveDamageBillByBillAndReservationId(damageBill, (long) 2);
    }
}
