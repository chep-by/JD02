package by.itacademy.service;

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
import java.util.List;

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
}
