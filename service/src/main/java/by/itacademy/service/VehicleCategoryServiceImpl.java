package by.itacademy.service;

import by.itacademy.repository.VehicleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleCategoryServiceImpl implements VehicleCategoryService {


    private VehicleCategoryRepository vehicleCategoryRepository;

    @Autowired
    public VehicleCategoryServiceImpl(VehicleCategoryRepository vehicleCategoryRepository) {
        this.vehicleCategoryRepository = vehicleCategoryRepository;
    }

    @Override
    public List<String> getAllVehicleCategories() {
        return vehicleCategoryRepository.findAllCategoriesNames();
    }




}
