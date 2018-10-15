package by.itacademy.repository;

import by.itacademy.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepositoryCustom {

    private final EntityManagerFactory entityManagerFactory;
    private final int deleteCountSymbols = 4;

    @Autowired
    public VehicleRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Object[]> getModelManufactureYearStandardCostMainImgRandomVehicles(int countOfRows) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Long> vehicleIds = entityManager.createQuery("select v.id from Vehicle v", Long.class).getResultList();

        StringBuilder stringBuilder = new StringBuilder();
        selectRandomRows(countOfRows, vehicleIds).forEach(number -> stringBuilder.append("v.id = ").append(number).append(" or "));
        String substring = stringBuilder.substring(0, stringBuilder.length() - deleteCountSymbols);
        List<Object[]> resultList = entityManager.createQuery("select v.id, v.model, v.manufacture, v.standardPrice, v.year, p.photoUrl from Photos p join p.vehicle v where p.photoUrl like 'main-%' and (" + substring + ")", Object[].class).getResultList();
        return resultList;
    }

    @Override
    public Long checkCount(VehicleDto vehicleDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<Vehicle> vehicleRoot = criteria.from(Vehicle.class);
        Join<Object, Object> vehicleCategory = vehicleRoot.join("vehicleCategory");
        criteria.select(cb.count(vehicleRoot));

        ArrayList<Predicate> predicatesList = new ArrayList<>();

        ifTrueAddPredicateInList(vehicleDto.getManufacture(), predicatesList, cb.equal(vehicleRoot.get("manufacture"), vehicleDto.getManufacture()));
        ifTrueAddPredicateInList(vehicleDto.getModel(), predicatesList, cb.equal(vehicleRoot.get("model"), vehicleDto.getModel()));
        ifTrueAddPredicateInList(vehicleDto.getVehicleCategoryName(), predicatesList, cb.equal(vehicleCategory.get("categoryName"), vehicleDto.getVehicleCategoryName()));

        predicatesList.add(cb.between(vehicleRoot.get("year"), vehicleDto.getYearMin(), vehicleDto.getYearMax()));

        Predicate [] predicatesArray = new Predicate[predicatesList.size()];
        predicatesList.toArray(predicatesArray);

        criteria.where(predicatesArray);

        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Vehicle> findByParams(VehicleDto vehicleDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Vehicle> criteria = cb.createQuery(Vehicle.class);
        Root<Vehicle> vehicleRoot = criteria.from(Vehicle.class);
        Join<Object, Object> vehicleCategory = vehicleRoot.join("vehicleCategory");

        criteria.select(vehicleRoot);

        ArrayList<Predicate> predicatesList = new ArrayList<>();
        ifTrueAddPredicateInList(vehicleDto.getManufacture(), predicatesList, cb.equal(vehicleRoot.get("manufacture"), vehicleDto.getManufacture()));
        ifTrueAddPredicateInList(vehicleDto.getModel(), predicatesList, cb.equal(vehicleRoot.get("model"), vehicleDto.getModel()));
        ifTrueAddPredicateInList(vehicleDto.getVehicleCategoryName(), predicatesList, cb.equal(vehicleCategory.get("categoryName"), vehicleDto.getVehicleCategoryName()));
        ifTrueAddPredicateInList(vehicleDto.getVehicleCategoryName(), predicatesList, cb.equal(vehicleCategory.get("categoryName"), vehicleDto.getVehicleCategoryName()));
        predicatesList.add(cb.between(vehicleRoot.get("year"), vehicleDto.getYearMin(), vehicleDto.getYearMax()));
//        predicatesList.add(cb.between(vehicleRoot.get("standardPrice"), carDto.getStandardPriceMin(), carDto.getStandardPriceMax()));
        Predicate [] predicatesArray = new Predicate[predicatesList.size()];
        predicatesList.toArray(predicatesArray);

        criteria.where(predicatesArray);

        List<Vehicle> list = entityManager.createQuery(criteria)
                .setFirstResult(vehicleDto.getPerPage() * ((vehicleDto.getPage() - 1)))
                .setMaxResults(vehicleDto.getPerPage())
                .getResultList();

        return list;
    }

    private List<Long> selectRandomRows(int countOfRows, List<Long> vehicleIds) {
        Collections.shuffle(vehicleIds);
        List<Long> subList = vehicleIds.subList(0, countOfRows);
        return subList;
    }

    private void ifTrueAddPredicateInList(String s, List<Predicate> list, Predicate predicate) {
        if (s != null && !"".equals(s)) {
            list.add(predicate);
        }
    }
}
