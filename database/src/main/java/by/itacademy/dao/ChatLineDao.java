package by.itacademy.dao;

import by.itacademy.entity.ChatLine;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChatLineDao extends BaseDao<ChatLine> {

    public ChatLineDao() {
        super(ChatLine.class);
    }

    public List<ChatLine> findAllChatLinesByUserLogin(String login) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<ChatLine> list = session.createQuery("select cl from ChatLine cl where cl.user.login=:login", ChatLine.class)
                .setParameter("login", login)
                .list();

        transaction.commit();
        session.close();
        return list;
    }
}
