package by.itacademy;

import by.itacademy.entity.ReservationStatus;
import by.itacademy.service.ReservationStatusService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationStatusServiceTest extends BaseServiceTest {

    @Autowired
    ReservationStatusService reservationStatusService;

    @Test
    public void findAllTest() {
        List<ReservationStatus> all = reservationStatusService.findAll();
        Assert.assertTrue(all.size() == 4);

    }
}
