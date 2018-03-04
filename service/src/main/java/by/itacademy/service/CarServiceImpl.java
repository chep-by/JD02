package by.itacademy.service;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import by.itacademy.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getCarsByParams(CarDto carDto) {
        return carRepository.findByParams(carDto);
    }

    @Override
    public Long getCount(CarDto carDto) {
        return carRepository.checkCount(carDto);
    }

    @Cacheable(cacheNames = "directory")
    @Override
    public List<String> getAllManufactures() {
        return carRepository.findAllManufactures();
    }

    @Cacheable(cacheNames = "directory")
    @Override
    public List<String> getAllModelsByManufacture(String manufacture) {
        return carRepository.findAllModelsByManufacture(manufacture);
    }

    @Cacheable(cacheNames = "request")
    @Override
    public int getCountOfPages(CarDto carDto) {
        return  (int) Math.ceil((double) getCount(carDto) / (double) carDto.getPerPage());
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
