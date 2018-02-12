package by.itacademy.dao;

import by.itacademy.entity.Chat;
import by.itacademy.entity.ChatLine;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class ChatDao extends BaseDao<Chat> {

    public ChatDao() {
        super(Chat.class);
    }

}
