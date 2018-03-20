package by.itacademy.service;

import by.itacademy.aspect.SaveOrUpdateLogger;
import by.itacademy.dto.VehicleDto;
import by.itacademy.entity.Photos;
import by.itacademy.entity.Vehicle;
import by.itacademy.entity.VehicleCategory;
import by.itacademy.repository.PhotosRepository;
import by.itacademy.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    public static final int INT = 4;
    private VehicleCategoryService vehicleCategoryService;
    private VehicleRepository vehicleRepository;
    private PhotosRepository photosRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleCategoryService vehicleCategoryService, PhotosRepository photosRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleCategoryService = vehicleCategoryService;
        this.photosRepository = photosRepository;
    }

    @Override
    public Long countOfVehicles() {
        return vehicleRepository.count();
    }

    @Cacheable(cacheNames = "request")
    @Override
    public List<Object[]> getModelManufactureYearStandardCostMainImgRandomVehicles(int countOfRows) {
        return vehicleRepository.getModelManufactureYearStandardCostMainImgRandomVehicles(countOfRows);
    }

    @Override
    public Vehicle findOne(Long id) {
        return vehicleRepository.findOne(id);
    }

    @SaveOrUpdateLogger
    @Override
    public void prepareAndSaveOrUpdateVehicle(Vehicle vehicle, String[] photoUrl, int main, String categoryName) {
        List<Photos> photos = new ArrayList<>();
        VehicleCategory vehicleCategory = vehicleCategoryService.findCategoryByCategoryName(categoryName);
        vehicle.setVehicleCategory(vehicleCategory);
        if (vehicle.getId() != 0L) {
            vehicleRepository.save(vehicle);
            photosRepository.deletePhotosByVehicle(vehicle);
        } else {
            vehicleRepository.save(vehicle);
        }
        for (int i = 0; i < photoUrl.length; i++) {
            if (i == main) {
                photoUrl[i] = "main-" + photoUrl[i];
            }
            if (photoUrl[i].length() > INT) {
                Photos photo = new Photos();
                photo.setVehicle(vehicle);
                photo.setPhotoUrl(photoUrl[i]);
                photosRepository.save(photo);
                photos.add(photo);
            }
        }
        vehicle.setPhotos(photos);
    }

    @Override
    public List<Vehicle> getVehiclesByParams(VehicleDto vehicleDto) {
        return vehicleRepository.findByParams(vehicleDto);
    }

    @Override
    public Long getCount(VehicleDto vehicleDto) {
        return vehicleRepository.checkCount(vehicleDto);
    }

    @Cacheable(cacheNames = "directory")
    @Override
    public List<String> getAllManufactures() {
        return vehicleRepository.findAllManufactures();
    }

    @Cacheable(cacheNames = "directory")
    @Override
    public List<String> getAllModelsByManufacture(String manufacture) {
        return vehicleRepository.findAllModelsByManufacture(manufacture);
    }

    @Cacheable(cacheNames = "request")
    @Override
    public int getCountOfPages(VehicleDto vehicleDto) {
        return (int) Math.ceil((double) getCount(vehicleDto) / (double) vehicleDto.getPerPage());
    }

    @Override
    public Map<String, List<String>> getMapManufactureModels() {
        Map<String, List<String>> manufactureModelsMap = new HashMap<>();
        List<String> allManufactures = getAllManufactures();
        allManufactures
                .forEach(manufacture -> manufactureModelsMap.put(manufacture, getAllModelsByManufacture(manufacture)));
        return manufactureModelsMap;
    }
}
