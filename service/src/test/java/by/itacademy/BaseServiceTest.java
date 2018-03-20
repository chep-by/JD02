package by.itacademy;

import by.itacademy.config.PersistenceConfig;
import by.itacademy.config.ServiceConfig;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@Ignore
@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class, PersistenceConfig.class})
public class BaseServiceTest {
}
