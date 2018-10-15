package by.itacademy.controller;

import by.itacademy.dto.CarDto;
import by.itacademy.service.CarService;
import by.itacademy.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class SelectVehicleFormController {

    private CarService carService;
    private VehicleCategoryService vehicleCategoryService;

    @Autowired
    public SelectVehicleFormController(CarService carService, VehicleCategoryService vehicleCategoryService) {
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

    @GetMapping("/select_cars")
    public String viewForm(CarDto carDto, Model model, HttpServletRequest request) {
        if (request.getQueryString() != null) {
            int countPages = carService.getCountOfPages(carDto);
            List<Car> carsByParams = carService.getCarsByParams(carDto);
            model.addAttribute("carsList", carsByParams);
            model.addAttribute("countPages", countPages);
        }
//        return "view_cars";
        return "select_cars";
    }

//    @PostMapping("/select_cars")
//    public String getForm(CarDto carDto) {
//
//        System.out.println(carDto);
//        return "view_cars";
//    }
}
