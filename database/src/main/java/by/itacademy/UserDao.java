package by.itacademy;


import by.itacademy.entity.Car;
import by.itacademy.entity.CostStrategy;
import by.itacademy.entity.VehicleCategory;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.Transmission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class UserDao {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CostStrategy costStrategy = new CostStrategy();
        costStrategy.setStrategy("our strategy");
        session.save(costStrategy);

        VehicleCategory luxury = new VehicleCategory();
        luxury.setCategoryName("Premium");
        luxury.setCostStrategy(costStrategy);
        session.save(luxury);

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
        session.save(car);
    }

    public Car getCar() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Car car = session.get(Car.class, 1L);

        session.close();
        sessionFactory.close();
        return car;
    }


    private int num = 3;

    int getNum() {
        return num;
    }

    void setNum(int num) {
        this.num = num;
    }
}
