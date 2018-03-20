package by.itacademy.controller;


import by.itacademy.entity.Car;
import by.itacademy.entity.DamageBill;
import by.itacademy.entity.Motorcycle;
import by.itacademy.entity.Reservation;
import by.itacademy.entity.ReservationStatus;
import by.itacademy.entity.Vehicle;
import by.itacademy.enums.FuelType;
import by.itacademy.enums.Gearbox;
import by.itacademy.enums.MotorcycleType;
import by.itacademy.enums.Transmission;
import by.itacademy.exceptions.ResourceNotFoundException;
import by.itacademy.service.DamageBillService;
import by.itacademy.service.ReservationService;
import by.itacademy.service.ReservationStatusService;
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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin")
public class AdminPagesController {

    private Reservation changeableReservation;
    private VehicleCategoryService vehicleCategoryService;
    private VehicleService vehicleService;
    private ReservationService reservationService;
    private ReservationStatusService reservationStatusService;
    private final DamageBillService damageBillService;

    @Autowired
    public AdminPagesController(VehicleCategoryService vehicleCategoryService, VehicleService vehicleService, ReservationService reservationService, ReservationStatusService reservationStatusService, DamageBillService damageBillService) {
        this.vehicleCategoryService = vehicleCategoryService;
        this.vehicleService = vehicleService;
        this.reservationService = reservationService;
        this.reservationStatusService = reservationStatusService;
        this.damageBillService = damageBillService;
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

    @GetMapping("")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/addvehicle")
    public String addVehicle() {
        return "addvehicle";
    }

    @GetMapping("/changevehicle/{id}")
    public String changeVehicleById(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.findOne(id);
        String vehicleType;
        if (vehicle == null) {
            throw new ResourceNotFoundException();
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
        return "success";
    }

    @PostMapping("/addmotorcycle")
    public String addMotorcycleForm(Motorcycle motorcycle, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(motorcycle, photoUrl, main, categoryName);
        return "success";
    }

    @PostMapping("/changecar")
    public String changeCarForm(Car car, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(car, photoUrl, main, categoryName);
        return "success";
    }

    @PostMapping("/changemotorcicle")
    public String changeMotorcycleForm(Motorcycle motorcycle, String[] photoUrl, int main, String categoryName) {
        vehicleService.prepareAndSaveOrUpdateVehicle(motorcycle, photoUrl, main, categoryName);
        return "success";
    }

    @PostMapping("/deletevehicle")
    public String deleteVehicle(Long vehicleId) {
        System.out.println(vehicleId);
        return "success";
    }


    @GetMapping("/reservations")
    public String viewReservations(Model model) {
        model.addAttribute("allReservationsList", reservationService.findAll());
        return "reservationadminview";
    }

    @GetMapping("/reservations/{id}")
    public String viewReservationById(@PathVariable Long id, Model model) {
        Reservation reservation = reservationService.findOne(id);
        if (reservation == null) {
            throw new ResourceNotFoundException();
        } else {
            model.addAttribute("allReservationStatuses", reservationStatusService.findAll());
            model.addAttribute("reservation", reservation);
        }
        return "reservationadminviewone";
    }

    @PostMapping("/changereservation")
    public String changeReservation(Reservation reservation, String status) {
        ReservationStatus reservationStatus = reservationStatusService.getReservationStatusByStatusName(status);
        reservation.setReservationStatus(reservationStatus);
        reservationService.updateByReservationDto(reservation);
        return "success";
    }

    @GetMapping("/damagebill/{id}")
    public String createDamageBillPage(@PathVariable Long id, Model model) {
        model.addAttribute("damagebill", new DamageBill());
        model.addAttribute("reservationid", id);
        return "damagebillpage";
    }

    @PostMapping("/createdamagebill")
    public String saveDamageBill(DamageBill damageBill, Long reservationId) {
        damageBillService.saveDamageBillByBillAndReservationId(damageBill, reservationId);
        return "success";
    }

}


