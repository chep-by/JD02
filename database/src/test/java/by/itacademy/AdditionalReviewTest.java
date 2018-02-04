package by.itacademy;

import by.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AdditionalReviewTest extends BaseTest {

    @Test
    public void saveAdditionalReviewTest() {
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
        Commend commendAdd = new Commend();
        commendAdd.setCommend("blah-blah again");

        Review review = new Review();
        review.setUser(user);
        review.setCommend(commend);
        session.save(review);

        AdditionalReview additionalReview = new AdditionalReview();
        additionalReview.setCommend(commendAdd);
        additionalReview.setReview(review);

        session.save(additionalReview);

        AdditionalReview additionalReviewFind = session.get(AdditionalReview.class, 1L);

        Assert.assertEquals(additionalReviewFind.getCommend().getCommend(), "blah-blah again");
        Assert.assertEquals(additionalReviewFind.getReview().getUser().getLogin(), "1");


        transaction.commit();
        session.close();
    }
}
