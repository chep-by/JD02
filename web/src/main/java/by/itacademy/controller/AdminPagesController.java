package by.itacademy.controller;


import by.itacademy.entity.Car;
import by.itacademy.entity.Motorcycle;
import by.itacademy.entity.Vehicle;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.MotorcycleType;
import by.itacademy.enums.Transmission;
import by.itacademy.service.VehicleCategoryService;
import by.itacademy.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin")
public class AdminPagesController {

    private VehicleCategoryService vehicleCategoryService;
    private VehicleService vehicleService;

    @Autowired
    public AdminPagesController(VehicleCategoryService vehicleCategoryService, VehicleService vehicleService) {
        this.vehicleCategoryService = vehicleCategoryService;
        this.vehicleService = vehicleService;
    }

    @ModelAttribute("car")
    public Car carForForm() {
        return new Car();
    }

    @ModelAttribute("moto")
    public Motorcycle motoForForm() {
        return new Motorcycle();
    }

    @ModelAttribute("fuelType")
    public List<String> fuelType() {
        return Stream.of(FuelType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @ModelAttribute("gearbox")
    public List<String> gearbox() {
        return Stream.of(Gearbox.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @ModelAttribute("transmission")
    public List<String> transmission() {
        return Stream.of(Transmission.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @ModelAttribute("motorcycleType")
    public List<String> motorcycleType() {
        return Stream.of(MotorcycleType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @ModelAttribute("categoryList")
    public List<String> vehicleCategories() {
        return vehicleCategoryService.getAllVehicleCategories();
    }

    @GetMapping("/addvehicle")
    public String addVehicle() {
        return "addvehicle";
    }

    @GetMapping("/changevehicle/{id}")
    public String changeVehicle(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.findOne(id);
        String vehicleType;
        if (vehicle == null) {
            return "error";
        } else {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                model.addAttribute("car", car);
                vehicleType = "car";
            } else {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                model.addAttribute("motorcycle", motorcycle);
                vehicleType = "motorcycle";
            }
        }
        model.addAttribute("vehicle", vehicleType);
        return "changevehicle";
    }

    @PostMapping("/addcar")
    public String addCarForm(Car car, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(car, photoUrl, main, categoryName);
        System.out.println(main);
        System.out.println(car);
        System.out.println(photoUrl.length);
        System.out.println(categoryName);
        Arrays.asList(photoUrl).forEach(System.out::print);
        return "success";
    }

    @PostMapping("/addmotorcycle")
    public String addMotorcycleForm(Motorcycle motorcycle, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(motorcycle, photoUrl, main, categoryName);
        System.out.println(main);
        System.out.println(motorcycle);
        System.out.println(photoUrl.length);
        System.out.println(categoryName);
        Arrays.asList(photoUrl).forEach(System.out::print);
        return "success";
    }

    @PostMapping("/changecar")
    public String changeCarForm(Car car, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(car, photoUrl, main, categoryName);
        System.out.println(car.getId());
        System.out.println(main);
        System.out.println(car);
        System.out.println(photoUrl.length);
        System.out.println(categoryName);
        Arrays.asList(photoUrl).forEach(System.out::print);
        return "success";
    }

    @PostMapping("/changemotorcicle")
    public String changeMotorcycleForm(Motorcycle motorcycle, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(motorcycle, photoUrl, main, categoryName);
        System.out.println(main);
        System.out.println(motorcycle);
        System.out.println(photoUrl.length);
        System.out.println(categoryName);
        Arrays.asList(photoUrl).forEach(System.out::print);
        return "success";
    }

    @PostMapping("/deletevehicle")
    public String deleteVehicle(Long vehicleId) {
        System.out.println(vehicleId);
        return "success";
    }


}


