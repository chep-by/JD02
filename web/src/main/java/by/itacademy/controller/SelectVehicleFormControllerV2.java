package by.itacademy.controller;

import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import by.itacademy.service.CarService;
import by.itacademy.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class SelectVehicleFormControllerV2 {

    private CarService carService;
    private VehicleCategoryService vehicleCategoryService;

    @Autowired
    public SelectVehicleFormControllerV2(CarService carService, VehicleCategoryService vehicleCategoryService) {
        this.carService = carService;
        this.vehicleCategoryService = vehicleCategoryService;
    }

    @ModelAttribute("carDto")
    public CarDto carDtoModel() {
        return new CarDto();
    }

    @ModelAttribute("allVehicleCategories")
    public List<String> allVehicleCategories() {
        return vehicleCategoryService.getAllVehicleCategories();
    }

    @ModelAttribute("allManufactureModelsMap")
    public Map<String, List<String>> allManufactureModelsMap() {
        return carService.getMapManufactureModels();
    }

    @GetMapping("/selectcarsv2")
    public String viewForm() {
        return "select_cars_v2";
    }

    @GetMapping("/getcarlist")
    @ResponseBody
    public List<Car> getCarList(CarDto carDto) {
        System.out.println(carDto);
        List<Car> carsByParams = carService.getCarsByParams(carDto);
        return carsByParams;
    }

    @GetMapping("/getcountpages")
    @ResponseBody
    public int getCountPages(@RequestBody CarDto carDto) {
        int countPages = carService.getCountOfPages(carDto);
        return countPages;
    }

//    @PostMapping("/select_cars")
//    public String getForm(CarDto carDto) {
//
//        System.out.println(carDto);
//        return "view_cars";
//    }
}
