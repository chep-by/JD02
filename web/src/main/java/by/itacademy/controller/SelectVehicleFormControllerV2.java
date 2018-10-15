package by.itacademy.controller;

import by.itacademy.dto.VehicleDto;
import by.itacademy.service.VehicleCategoryService;
import by.itacademy.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class SelectVehicleFormControllerV2 {

    private VehicleService vehicleService;
    private VehicleCategoryService vehicleCategoryService;

    @Autowired
    public SelectVehicleFormControllerV2(VehicleService vehicleService, VehicleCategoryService vehicleCategoryService) {
        this.vehicleService = vehicleService;
        this.vehicleCategoryService = vehicleCategoryService;
    }

    @ModelAttribute("vehicleDto")
    public VehicleDto vehicleDtoModel() {
        return new VehicleDto();
    }

    @ModelAttribute("allVehicleCategories")
    public List<String> allVehicleCategories() {
        return vehicleCategoryService.getAllVehicleCategories();
    }

    @ModelAttribute("allManufactureModelsMap")
    public Map<String, List<String>> allManufactureModelsMap() {
        return vehicleService.getMapManufactureModels();
    }

    @GetMapping("/select_vehicles")
    public String viewForm(VehicleDto vehicleDto, Model model, HttpServletRequest request) {
        if (request.getQueryString() != null) {
            int countPages = vehicleService.getCountOfPages(vehicleDto);
            List<Vehicle> vehiclesByParams = vehicleService.getVehiclesByParams(vehicleDto);
            model.addAttribute("vehicleList", vehiclesByParams);
            model.addAttribute("countPages", countPages);
        }
//        return "view_cars";
        return "select_vehicles";
    }

//    @PostMapping("/select_cars")
//    public String getForm(CarDto carDto) {
//
//        System.out.println(carDto);
//        return "view_cars";
//    }
}
