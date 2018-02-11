package by.itacademy;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarDao extends BaseDao<Car> {

    public static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    public CarDao() {
        super(Car.class);
    }

    public List<Car> findByParams(CarDto carDto) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Car> list = session.createQuery("select c from Car c where c.manufacture=:manufacture " +
                " and c.model=:model and c.year>:minYear and c.year<:maxYear", Car.class)
                .setParameter("manufacture", carDto.getManufacture())
                .setParameter("model", carDto.getModel())
                .setParameter("minYear", carDto.getYearMin())
                .setParameter("maxYear", carDto.getYearMax())
                .setFirstResult(carDto.getPerPage() * ((carDto.getPage() - 1)))
                .setMaxResults(carDto.getPerPage())
                .list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Long checkCount(CarDto carDto) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Long result = (Long) session.createQuery("select count(*) from Car c where c.manufacture=:manufacture " +
                " and c.model=:model and c.year>:minYear and c.year<:maxYear")
                .setParameter("manufacture", carDto.getManufacture())
                .setParameter("model", carDto.getModel())
                .setParameter("minYear", carDto.getYearMin())
                .setParameter("maxYear", carDto.getYearMax())
                .uniqueResult();

        session.getTransaction().commit();
        session.close();
        return result;
    }

}

