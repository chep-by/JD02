package by.itacademy.controller;

import by.itacademy.dto.ReservationDto;
import by.itacademy.entity.Car;
import by.itacademy.entity.Motorcycle;
import by.itacademy.entity.Photos;
import by.itacademy.entity.Vehicle;
import by.itacademy.exceptions.ResourceNotFoundException;
import by.itacademy.service.CostStrategyService;
import by.itacademy.service.ReservationService;
import by.itacademy.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;

@Controller
public class CurrentVehicleController {

    public static final int SUBSTRING_SYMBOLS = 5;
    private VehicleService vehicleService;
    private ReservationService reservationService;
    private CostStrategyService costStrategyService;

    @Autowired
    public CurrentVehicleController(VehicleService vehicleService, ReservationService reservationService, CostStrategyService costStrategyService) {
        this.vehicleService = vehicleService;
        this.reservationService = reservationService;
        this.costStrategyService = costStrategyService;
    }

    @ModelAttribute("reservationData")
    public ReservationDto reservationDto() {
        return new ReservationDto();
    }

    @GetMapping("vehicle/{id}")
    public String getPerson(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.findOne(id);
        if (vehicle == null) {
           throw new ResourceNotFoundException();
        } else {
            List<Photos> photos = vehicle.getPhotos();
            String mainPhotoUrl = null;
            List<String> otherPhotos = new LinkedList<String>();
            for (Photos photo : photos) {
                if (photo.getPhotoUrl().startsWith("main-")) {
                    mainPhotoUrl = photo.getPhotoUrl().substring(SUBSTRING_SYMBOLS);
                } else {
                    otherPhotos.add(photo.getPhotoUrl());
                }
            }
            model.addAttribute("id", id);
            model.addAttribute("CostStrategy", costStrategyService.decodeCostStrategy(vehicle.getVehicleCategory().getCostStrategy().getStrategy()));
            model.addAttribute("mainImg", mainPhotoUrl);
            model.addAttribute("otherImg", otherPhotos);
            model.addAttribute("imagesCount", photos.size() - 1);
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

//    private Map<String, Integer> costStrategyToMap(String strategy, Integer standardPrice) {
//        Map<String, Integer> map = new LinkedHashMap<>();
//        String[] split = strategy.split("__");
//        for (int i = 0; i < split.length - 1; i++) {
//            map.put(split[i].split("-")[0] + " - " + split[i + 1].split("-")[0], (int) Math.ceil(Double.parseDouble(split[i].split("-")[1]) * standardPrice / 100));
//        }
//        map.put(split[split.length - 1].split("-")[0], (int) Math.ceil(Double.parseDouble(split[split.length - 1].split("-")[1]) * standardPrice / 100));
//        return map;
//    }

}
