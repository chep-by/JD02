package by.itacademy;

import by.itacademy.entity.Car;

public class UserService {
    public int userPlusOne() {
        return new UserDao().getNum() + 1;
    }

    public String getCarInfo() {
        Car car = new UserDao().getCar();
        return car.getManufacture() + " " + car.getModel() + " год выпуска:" + car.getYear() + " объем:"
                + car.getCubicCapacity() + "см^3,  мощность:" + car.getPower() + " стоимость за день аренды:" + car.getStandardPrice();

    }

}


