package by.itacademy.dao;


import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDao extends BaseDao<User> {

    public UserDao() {
        super(User.class);
    }

    public User findByLogin(String login) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        User user = session.createQuery("select u from User u where u.login=:login", User.class)
                .setParameter("login", login)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();
        return user;
    }
}

