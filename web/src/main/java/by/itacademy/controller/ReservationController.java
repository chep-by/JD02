package by.itacademy.controller;

import by.itacademy.dto.DateIntervalDto;
import by.itacademy.dto.ReservationDto;
import by.itacademy.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ModelAttribute("reservationData")
    public ReservationDto reservationDto() {
        return new ReservationDto();
    }

    @GetMapping("/reservation/{id}")
    public String reservationView(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "reservation";
    }

    @PostMapping("/reservation")
    public String createReservation(Authentication authentication, ReservationDto reservationDto) {
        reservationDto.setUserName(authentication.getName());
        reservationService.createAndSaveReservation(reservationDto);
        return "redirect:user/" + authentication.getName() + "/reservations";
    }

    @PostMapping("/reservationdates")
    @ResponseBody
    public List<DateIntervalDto> blockDates(Long vehicleId) {
        return reservationService.findBlockedDatesByVehicleId(vehicleId);
    }

}
