package by.itacademy.entitytests;

import by.itacademy.entity.User;
import by.itacademy.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseEntityTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveUserTest() {

        User user1 = userRepository.findOne(1L);

        Assert.assertEquals(user1.getLogin(), "admin");
    }

}
