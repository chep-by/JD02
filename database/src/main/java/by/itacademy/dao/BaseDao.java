package by.itacademy.dao;

import by.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {

    static final SessionFactory SESSION_FACTORY
            = new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass;

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Long save(T objectToSave) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.save(objectToSave);

        session.getTransaction().commit();
        session.close();
        return objectToSave.getId();
    }

    public T findById(Long id) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        T result = session.get(entityClass, id);

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void update(T objectToUpdate) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.update(objectToUpdate);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(T objectToDelete) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.delete(objectToDelete);

        session.getTransaction().commit();
        session.close();
    }

    public List<T> findAll() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<T> list = session.createQuery("select t from " + entityClass.getName() + " t", entityClass).list();

        session.getTransaction().commit();
        session.close();
        return list;
    }
}
