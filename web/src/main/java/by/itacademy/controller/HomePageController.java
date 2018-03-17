package by.itacademy.controller;

import by.itacademy.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomePageController {

    private VehicleService vehicleService;

    private static final int COUNT_OF_ROWS_ON_HOME_PAGE = 6;

    @Autowired
    public HomePageController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ModelAttribute("vehicles")
    private List<Object[]> sixVehicles() {
        return vehicleService.getModelManufactureYearStandardCostMainImgRandomVehicles(COUNT_OF_ROWS_ON_HOME_PAGE);
    }

    @GetMapping("/")
    public String homepage() {
        return "home";
    }
}
