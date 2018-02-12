package by.itacademy.entitytests;

import by.itacademy.BaseTest;
import by.itacademy.entity.Chat;
import by.itacademy.entity.ChatLine;
import by.itacademy.entity.Commend;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class ChatLinesTest extends BaseTest {

    @Test
    public void saveTest() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Chat chat = new Chat();
        session.save(chat);

        User user = new User();
        user.setLogin("3");
        user.setPassword("1");
        session.save(user);

        ChatLine chatLine = new ChatLine();
        Commend commend = new Commend();
        commend.setCommend("mess");
        chatLine.setCommend(commend);
        chatLine.setChat(chat);
        chatLine.setUser(user);
        session.save(chatLine);

        ChatLine chatLine1 = session.get(ChatLine.class, 1L);

        Assert.assertEquals(chatLine1.getUser(), user);
        Assert.assertEquals(chatLine1.getChat(), chat);
        Assert.assertEquals(chatLine1.getCommend(), commend);


        transaction.commit();
        session.close();
    }

}
