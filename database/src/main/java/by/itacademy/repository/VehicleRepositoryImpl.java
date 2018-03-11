package by.itacademy.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleRepositoryImpl implements VehicleRepositoryCustom {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public VehicleRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Object[]> getModelManufactureYearStandardCostRandomSixVehicles(Long countOfVehicles) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder stringBuilder = new StringBuilder();
        generateRandomNumbers(countOfVehicles).forEach(number -> stringBuilder.append("id = ").append(number).append(" or "));
        String substring = stringBuilder.substring(0, stringBuilder.length() - 4);
        List<Object[]> resultList = entityManager.createQuery("select v.id, v.model, v.manufacture, v.standardPrice, v.year from Vehicle v where "+substring, Object[].class).getResultList();
        return resultList;
    }

    private List<Integer> generateRandomNumbers(Long maxNumber) {
        ArrayList<Integer> numbersGenerated = new ArrayList<>();
        Random randNumber = new Random();
        for (int i = 0; i < 6; i++) {
            int iNumber = randNumber.nextInt(maxNumber.intValue()) + 1;
            if (!numbersGenerated.contains(iNumber)) {
                numbersGenerated.add(iNumber);
            } else {
                i--;
            }
        }
        return numbersGenerated;
    }
}
