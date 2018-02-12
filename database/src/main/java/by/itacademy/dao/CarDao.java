package by.itacademy.dao;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import org.hibernate.Session;


import javax.persistence.Query;
import java.util.List;

public class CarDao extends BaseDao<Car> {

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


//    public List<Car> findByParams(CarDto carDto) {
//        Session session = SESSION_FACTORY.openSession();
//        session.beginTransaction();
//        List<Car> list  =session.createQuery("select c from Car c where (c.manufacture=:manufacture or :manufacture is null) " +
//                " and (c.model=:model or :model is null) and (c.year>:minYear or :minYear is null)   and (c.year<:maxYear or :maxYear is null)" , Car.class)
//                .setParameter("manufacture", carDto.getManufacture())
//                .setParameter("model", carDto.getModel())
//                .setParameter("minYear", carDto.getYearMin())
//                .setParameter("maxYear", carDto.getYearMax())
//                .setFirstResult(carDto.getPerPage() * ((carDto.getPage() - 1)))
//                .setMaxResults(carDto.getPerPage())
//                .list();
//        session.getTransaction().commit();
//        session.close();
//        return list;
//    }

    private void setQ(Query q, String param, Object value) {
        if (value != null)
            q.setParameter(param, value);
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

