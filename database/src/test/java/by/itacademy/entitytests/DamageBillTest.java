package by.itacademy.entitytests;

import by.itacademy.entity.*;
import by.itacademy.repository.DamageBillRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DamageBillTest extends BaseEntityTest {

    @Autowired
    private DamageBillRepository damageBillRepository;

    @Test
    public void saveTest() {

        DamageBill damageBillFind = damageBillRepository.findOne(1L);

        Assert.assertEquals(damageBillFind.getCommend(), "Damaged door");
    }

}
