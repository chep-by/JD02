package by.itacademy.controller;

import by.itacademy.CarService;
import by.itacademy.dto.CarDto;
import by.itacademy.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class SelectVehicleFormController {

    private CarService carService;

    @Autowired
    public SelectVehicleFormController(CarService carService) {
        this.carService = carService;
    }

    @ModelAttribute("carDto")
    public CarDto carDtoModel() {
        return new CarDto();
    }

    @ModelAttribute("allManufactures")
    public List<String> allManufactures() {
        List<String> allManufactures = Arrays.asList("BMW", "AUDI");
        return allManufactures;
    }

    @ModelAttribute("allBMW")
    public List<String> allBMW() {
        List<String> allBMW = Arrays.asList("645", "325", "740");
        return allBMW;
    }

    @ModelAttribute("allAudi")
    public List<String> allAudi() {
        List<String> allAudi = Arrays.asList("A4", "A5", "A6");
        return allAudi;
    }

    @GetMapping("/select_cars")
    public String viewForm(CarDto carDto, Model model) {
        Long count = carService.getCount(carDto);
        int countPages = (int) Math.ceil((double) count / (double) carDto.getPerPage());
        List<Car> carsByParams = carService.getCarsByParams(carDto);
        model.addAttribute("carsList", carsByParams);
        model.addAttribute("countPages", countPages);
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
