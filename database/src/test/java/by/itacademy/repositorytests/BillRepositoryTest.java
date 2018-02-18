package by.itacademy.repositorytests;

import by.itacademy.entity.Bill;
import by.itacademy.repository.BillRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BillRepositoryTest extends BaseRepositoryTest {
    @Autowired
    private BillRepository billRepository;

    @Test
    public void findByReservation_IdTest() {

        Bill byReservation_id = billRepository.findByReservationId(1l);

        Bill one = billRepository.findOne(1l);

        Assert.assertEquals(one.getFinalCost(), byReservation_id.getFinalCost());


    }
}
