package by.itacademy.service;


import by.itacademy.entity.VehicleCategory;

import java.util.List;

public interface VehicleCategoryService {

    List<String> getAllVehicleCategories();

    VehicleCategory findCategoryByCategoryName(String categoryName);
}
