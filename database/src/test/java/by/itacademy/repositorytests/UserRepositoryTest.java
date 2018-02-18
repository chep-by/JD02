package by.itacademy.repositorytests;

import by.itacademy.entity.User;
import by.itacademy.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOneByLoginTest() {

        User alex = userRepository.findOneByLogin("alex");

        Assert.assertEquals(alex.getLogin(), "alex");
    }


}
