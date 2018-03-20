package by.itacademy.entitytests;

import by.itacademy.entity.Motorcycle;
import by.itacademy.enums.MotorcycleType;
import by.itacademy.repository.MotorcycleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MotorcycleTest extends BaseEntityTest {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Test
    public void saveTest() {
        Motorcycle motorcycleFind = motorcycleRepository.findOne(2L);

        Assert.assertTrue(motorcycleFind.getMotorcycleType() == MotorcycleType.SPORT);
    }

}
