package by.itacademy;


import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import by.itacademy.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserServiceImplTest extends BaseServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void loadUserByUsernameSuccessfulTest() {
        UserDetails max = userService.loadUserByUsername("max");
        Assert.assertTrue(max.getPassword() != null);
    }

    @Test
    public void loadUserByUsernameFailureTest() {
        try {
            UserDetails admin = userService.loadUserByUsername("sjhfds");
        }
        catch (Exception UsernameNotFoundException) {
            Assert.assertTrue(true);
        }
    }


    @Test
    public void newUserRegistrationTest() {
        User user = new User();
        user.setLogin("lol");
        user.setPassword("kek");
        userService.newUserRegistration(user);

    }
}
