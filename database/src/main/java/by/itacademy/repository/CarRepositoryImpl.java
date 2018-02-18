package by.itacademy.repository;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CarRepositoryImpl implements CarRepositoryCustom {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CarRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Long checkCount(CarDto carDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Long result = entityManager.createQuery("select count(*) from Car c where c.manufacture=:manufacture "
                + " and c.model=:model and c.year>:minYear and c.year<:maxYear", Long.class)
                .setParameter("manufacture", carDto.getManufacture())
                .setParameter("model", carDto.getModel())
                .setParameter("minYear", carDto.getYearMin())
                .setParameter("maxYear", carDto.getYearMax())
                .getSingleResult();

        return result;
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
//        Root<Car> car = criteria.from(Car.class);
////        Join<Object, Object> vehicleCategory = car.join("vehicleCategory");
//
//        criteria = criteria.select(cb.count(car));
//
//        if (carDto.getManufacture() != null) {
//            criteria = criteria.where(cb.equal(car.get("manufacture"), carDto.getManufacture()));
//        }
//        if (carDto.getModel() != null) {
//            criteria = criteria.where(cb.equal(car.get("model"), carDto.getModel()));
//        }
////        if (carDto.getVehicleCategoryName() != null) {
////            criteria.where(cb.equal(vehicleCategory.get("categoryName"), carDto.getVehicleCategoryName()));
////        }
////        if (carDto.getGearbox() != null) {
////            criteria.where(cb.equal(car.get("gearbox"), carDto.getGearbox()));
////        }
////        if (carDto.getTransmission() != null) {
////            criteria.where(cb.equal(car.get("transmission"),  carDto.getTransmission()));
////        }
//        criteria = criteria.where(cb.between(car.get("year"), carDto.getYearMin(), carDto.getYearMax()));
//
//        Long result = entityManager.createQuery(criteria).getSingleResult();
//
//        return result;
    }

    @Override
    public List<Car> findByParams(CarDto carDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Car> list = entityManager.createQuery("select c from Car c where c.manufacture=:manufacture "
                + " and c.model=:model and c.year>:minYear and c.year<:maxYear", Car.class)
                .setParameter("manufacture", carDto.getManufacture())
                .setParameter("model", carDto.getModel())
                .setParameter("minYear", carDto.getYearMin())
                .setParameter("maxYear", carDto.getYearMax())
                .setFirstResult(carDto.getPerPage() * ((carDto.getPage() - 1)))
                .setMaxResults(carDto.getPerPage())
                .getResultList();

        return list;

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Car> criteria = cb.createQuery(Car.class);
//        Root<Car> car = criteria.from(Car.class);
////        Join<Object, Object> vehicleCategory = car.join("vehicleCategory");
//
//        criteria = criteria.select(car);
//
//        if (carDto.getManufacture() != null) {
//            criteria = criteria.where(cb.equal(car.get("manufacture"), carDto.getManufacture()));
//        }
//        if (carDto.getModel() != null) {
//            criteria = criteria.where(cb.equal(car.get("model"), carDto.getModel()));
//        }
////        if (carDto.getVehicleCategoryName() != null) {
////            criteria.where(cb.equal(vehicleCategory.get("categoryName"), carDto.getVehicleCategoryName()));
////        }
////        if (carDto.getGearbox() != null) {
////            criteria.where(cb.equal(car.get("gearbox"), carDto.getGearbox()));
////        }
////        if (carDto.getTransmission() != null) {
////            criteria.where(cb.equal(car.get("transmission"), carDto.getTransmission()));
////        }
//        criteria = criteria.where(cb.between(car.get("year"), carDto.getYearMin(), carDto.getYearMax()));
//       //         .where(cb.between(car.get(("standardPrice")), carDto.getStandardPriceMin(), carDto.getStandardPriceMax()));
//
//        List<Car> list = entityManager.createQuery(criteria)
//                .setFirstResult(carDto.getPerPage() * ((carDto.getPage() - 1)))
//                .setMaxResults(carDto.getPerPage())
//                .getResultList();
//
//        return list;
    }
}
