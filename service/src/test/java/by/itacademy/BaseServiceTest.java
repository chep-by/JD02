package by.itacademy;

import by.itacademy.config.PersistenceConfig;
import by.itacademy.config.ServiceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class, PersistenceConfig.class})
public class BaseServiceTest {
}
