package by.itacademy;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class RoleTest extends BaseTest {

    @Test
    public void saveRoleTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        User user1 = new User();
        user1.setLogin("1");
        user1.setPassword("1");
        session.save(user1);
        Set<User> users = new HashSet<>();
        users.add(user1);


        Role role = new Role();
        role.setUsers(users);
        role.setRole("admin");
        session.save(role);

        Role role1 = session.get(Role.class, 1L);

        Assert.assertEquals(role1.getRole(), "admin");
        Assert.assertEquals(role1.getUsers().iterator().next(), user1);

        transaction.commit();
        session.close();
    }

}
