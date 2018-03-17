package by.itacademy.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    private List<Long> selectRandomRows(int countOfRows, List<Long> vehicleIds) {
        Collections.shuffle(vehicleIds);
        List<Long> subList = vehicleIds.subList(0, countOfRows);
        return subList;
    }
}
