package by.itacademy;


import by.itacademy.entity.Role;
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
        UserDetails admin = userService.loadUserByUsername("admin");
        Assert.assertEquals(admin.getPassword(), "admin");
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
    public void Test() {
        Set<String> collect = Stream.of("f", "b", "s").collect(Collectors.toSet());
        System.out.println(collect.getClass());

    }
}
