package by.itacademy.daotests;

import by.itacademy.dao.ChatDao;
import by.itacademy.dao.ChatLineDao;
import by.itacademy.dao.UserDao;
import by.itacademy.entity.Chat;
import by.itacademy.entity.ChatLine;
import by.itacademy.entity.Commend;
import by.itacademy.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ChatLineDaoTest {

    @Test
    public void findAllChatLinesByUserLoginTest() {
        Chat chat = new Chat();
        new ChatDao().save(chat);

        User user = new User();
        user.setLogin("3");
        user.setPassword("1");
        new UserDao().save(user);

        ChatLine chatLine = new ChatLine();
        Commend commend = new Commend();
        commend.setCommend("mess");
        chatLine.setCommend(commend);
        chatLine.setChat(chat);
        chatLine.setUser(user);

        ChatLine chatLine1 = new ChatLine();
        Commend commend1 = new Commend();
        commend1.setCommend("mess1");
        chatLine1.setCommend(commend1);
        chatLine1.setChat(chat);
        chatLine1.setUser(user);

        ChatLineDao chatLineDao = new ChatLineDao();
        chatLineDao.save(chatLine);
        chatLineDao.save(chatLine1);

        List<ChatLine> allChatLinesByUserLogin = chatLineDao.findAllChatLinesByUserLogin("3");

        Assert.assertEquals(allChatLinesByUserLogin.size(), 2);

    }
}
