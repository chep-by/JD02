package by.itacademy;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import by.itacademy.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
