package by.itacademy;

import by.itacademy.dao.CarDao;
import by.itacademy.entity.Car;

import java.util.List;

public class UserService {

    public String getCarInfo() {
        List <Car> car = new CarDao().findAll();
        return car.get(0).getManufacture() + " " + car.get(0).getModel() + " год выпуска:" + car.get(0).getYear() + " объем:"
                + car.get(0).getCubicCapacity() + "см^3,  мощность:" + car.get(0).getPower() + " стоимость за день аренды:" + car.get(0).getStandardPrice();


    }

}


