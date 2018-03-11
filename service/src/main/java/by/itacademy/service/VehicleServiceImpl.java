package by.itacademy.service;

import by.itacademy.entity.Vehicle;
import by.itacademy.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Long countOfVehicles() {
        return vehicleRepository.count();
    }

    @Cacheable(cacheNames = "request")
    @Override
    public List<Object[]> getModelManufactureYearStandardCostRandomSixVehicles() {
        return vehicleRepository.getModelManufactureYearStandardCostRandomSixVehicles(countOfVehicles());
    }

    @Override
    public Vehicle findOne(Long id) {
        return vehicleRepository.findOne(id);
    }
}
