package by.itacademy.repository;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepositoryCustom {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CarRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Long checkCount(CarDto carDto) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Long result = entityManager.createQuery("select count(*) from Car c where c.manufacture=:manufacture "
//                + " and c.model=:model and c.year>:minYear and c.year<:maxYear", Long.class)
//                .setParameter("manufacture", carDto.getManufacture())
//                .setParameter("model", carDto.getModel())
//                .setParameter("minYear", carDto.getYearMin())
//                .setParameter("maxYear", carDto.getYearMax())
//                .getSingleResult();
//
//        return result;

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<Car> car = criteria.from(Car.class);
        Join<Object, Object> vehicleCategory = car.join("vehicleCategory");
        criteria.select(cb.count(car));

        ArrayList<Predicate> predicatesList = new ArrayList<>();

        ifTrueAddPredicateInList(carDto.getManufacture(), predicatesList, cb.equal(car.get("manufacture"), carDto.getManufacture()));
        ifTrueAddPredicateInList(carDto.getModel(), predicatesList, cb.equal(car.get("model"), carDto.getModel()));
        ifTrueAddPredicateInList(carDto.getVehicleCategoryName(), predicatesList, cb.equal(vehicleCategory.get("categoryName"), carDto.getVehicleCategoryName()));

        predicatesList.add(cb.between(car.get("year"), carDto.getYearMin(), carDto.getYearMax()));

        Predicate [] predicatesArray = new Predicate[predicatesList.size()];
        predicatesList.toArray(predicatesArray);

        criteria.where(predicatesArray);

        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Car> findByParams(CarDto carDto) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        List<Car> list = entityManager.createQuery("select c from Car c where c.manufacture=:manufacture "
//                + " and c.model=:model and c.year>:minYear and c.year<:maxYear", Car.class)
//                .setParameter("manufacture", carDto.getManufacture())
//                .setParameter("model", carDto.getModel())
//                .setParameter("minYear", carDto.getYearMin())
//                .setParameter("maxYear", carDto.getYearMax())
//                .setFirstResult(carDto.getPerPage() * ((carDto.getPage() - 1)))
//                .setMaxResults(carDto.getPerPage())
//                .getResultList();
//
//        return list;

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Car> criteria = cb.createQuery(Car.class);
        Root<Car> car = criteria.from(Car.class);
        Join<Object, Object> vehicleCategory = car.join("vehicleCategory");

        criteria.select(car);

        ArrayList<Predicate> predicatesList = new ArrayList<>();
        ifTrueAddPredicateInList(carDto.getManufacture(), predicatesList, cb.equal(car.get("manufacture"), carDto.getManufacture()));
        ifTrueAddPredicateInList(carDto.getModel(), predicatesList, cb.equal(car.get("model"), carDto.getModel()));
        ifTrueAddPredicateInList(carDto.getVehicleCategoryName(), predicatesList, cb.equal(vehicleCategory.get("categoryName"), carDto.getVehicleCategoryName()));
        ifTrueAddPredicateInList(carDto.getVehicleCategoryName(), predicatesList, cb.equal(vehicleCategory.get("categoryName"), carDto.getVehicleCategoryName()));
        predicatesList.add(cb.between(car.get("year"), carDto.getYearMin(), carDto.getYearMax()));
//        predicatesList.add(cb.between(car.get("standardPrice"), carDto.getStandardPriceMin(), carDto.getStandardPriceMax()));
        Predicate [] predicatesArray = new Predicate[predicatesList.size()];
        predicatesList.toArray(predicatesArray);

        criteria.where(predicatesArray);

        List<Car> list = entityManager.createQuery(criteria)
                .setFirstResult(carDto.getPerPage() * ((carDto.getPage() - 1)))
                .setMaxResults(carDto.getPerPage())
                .getResultList();

        return list;
    }

    private void ifTrueAddPredicateInList(String s, List<Predicate> list, Predicate predicate) {
        if (s != null && !"".equals(s)) {
            list.add(predicate);
        }
    }


}
