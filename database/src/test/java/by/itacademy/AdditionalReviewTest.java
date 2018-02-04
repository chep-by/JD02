package by.itacademy;

import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class AdditionalReviewTest extends BaseTest {

    @Test
    public void saveAdditionalReviewTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();
    }
}
