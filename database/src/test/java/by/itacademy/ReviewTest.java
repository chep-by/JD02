package by.itacademy;

import by.itacademy.entity.Commend;
import by.itacademy.entity.Review;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ReviewTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Role role = new Role();
        role.setRole("admin");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        session.save(role);

        User user = new User();
        user.setLogin("1");
        user.setPassword("1");
        user.setRoles(roles);
        session.save(user);

        Commend commend = new Commend();
        commend.setCommend("blah-blah");

        Review review = new Review();
        review.setUser(user);
        review.setCommend(commend);

        session.save(review);

        Review reviewFind = session.get(Review.class, 1L);

        Assert.assertEquals(reviewFind.getUser(), user);
        Assert.assertEquals(reviewFind.getCommend().getCommend(), "blah-blah");

        transaction.commit();
        session.close();
    }

}
