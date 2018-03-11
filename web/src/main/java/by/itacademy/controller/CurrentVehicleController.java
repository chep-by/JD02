package by.itacademy.controller;

import by.itacademy.entity.Car;
import by.itacademy.entity.Motorcycle;
import by.itacademy.entity.Vehicle;
import by.itacademy.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;

@Controller
public class CurrentVehicleController {

    private VehicleService vehicleService;

    @Autowired
    public CurrentVehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("vehicle/{id}")
    public String getPerson(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.findOne(id);


        if (vehicle == null) {
            return "error";
        } else {
//            int length = new File("/resources/images/vehicles/" + id.toString()).listFiles().length; //TODO: Check why it's doesn't work
//            model.addAttribute("imagesCount", length - 1);
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                model.addAttribute("car", car);
                return "car";
            } else {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                model.addAttribute("motorcycle", motorcycle);
                return "motorcycle";
            }
        }
    }

}
