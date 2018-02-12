package by.itacademy.daotests;

import by.itacademy.dao.CarDao;
import by.itacademy.dao.CostStrategyDao;
import by.itacademy.dao.VehicleCategoryDao;
import by.itacademy.entity.Car;
import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.VehicleCategory;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CarDaoTest  {

    @Test
    public void saveTest() {
        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        new CostStrategyDao().save(costStrategy);

        VehicleCategory luxury = new VehicleCategory();
        luxury.setCategoryName("Premium");
        luxury.setCostStrategy(costStrategy);
        new VehicleCategoryDao().save(luxury);

        Car car = new Car();
        car.setVehicleCategory(luxury);
        car.setCubicCapacity(4500);
        car.setManufacture("BMW");
        car.setModel("645");
        car.setPower(330);
        car.setStandardPrice(100);
        car.setYear(2007);
        car.setFuelType(FuelType.PETROL);
        car.setGearbox(Gearbox.SEMI_AUTOMATIC);
        car.setTransmission(Transmission.REAR_WHEEL);
        new CarDao().save(car);

        Car car1 = new Car();
        car1.setVehicleCategory(luxury);
        car1.setCubicCapacity(2000);
        car1.setManufacture("BMW");
        car1.setModel("320i");
        car1.setPower(200);
        car1.setStandardPrice(80);
        car1.setYear(2010);
        car1.setFuelType(FuelType.PETROL);
        car1.setGearbox(Gearbox.SEMI_AUTOMATIC);
        car1.setTransmission(Transmission.REAR_WHEEL);
        new CarDao().save(car1);

        Car car3 = new Car();
        car3.setVehicleCategory(luxury);
        car3.setCubicCapacity(4000);
        car3.setManufacture("BMW");
        car3.setModel("740");
        car3.setPower(300);
        car3.setStandardPrice(120);
        car3.setYear(2013);
        car3.setFuelType(FuelType.PETROL);
        car3.setGearbox(Gearbox.SEMI_AUTOMATIC);
        car3.setTransmission(Transmission.FOUR_WHEEL);

        CarDao carDao = new CarDao();

        carDao.save(car3);
        Car assertCar = carDao.findById(3l);
        Assert.assertEquals(assertCar.getStandardPrice(), car3.getStandardPrice());

        List<Car> cars = carDao.findAll();
        Assert.assertTrue(cars.size() == 3);

        Car byId = carDao.findById(2L);
        Assert.assertEquals(car1.getPower(), byId.getPower());

        car.setStandardPrice(130);
        carDao.update(car);
        Car byId1 = carDao.findById(1L);
        Assert.assertEquals(byId1.getStandardPrice(), 130);

        carDao.delete(car3);
        Assert.assertEquals(carDao.findAll().size(), 2);
    }

}
