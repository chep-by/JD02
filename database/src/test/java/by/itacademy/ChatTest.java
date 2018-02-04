package by.itacademy;

import by.itacademy.entity.Chat;
import by.itacademy.entity.ChatLine;
import by.itacademy.entity.Commend;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ChatTest extends BaseTest {

    @Test
    public void saveChatTest() {

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

        session.refresh(chat);

        Chat findChat = session.get(Chat.class, 1L);

        Assert.assertTrue(findChat.getChatLine().contains(chatLine));
        transaction.commit();
        session.close();
    }

}
