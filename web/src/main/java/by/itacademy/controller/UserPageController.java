package by.itacademy.controller;

import by.itacademy.exceptions.ResourceNotFoundException;
import by.itacademy.service.AdditionalUserInfoService;
import by.itacademy.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/{username}")
public class UserPageController {

    private AdditionalUserInfoService additionalUserInfoService;
    private ReservationService reservationService;

    @Autowired
    public UserPageController(AdditionalUserInfoService additionalUserInfoService, ReservationService reservationService) {
        this.additionalUserInfoService = additionalUserInfoService;
        this.reservationService = reservationService;

    }

    @GetMapping("/addinfo")
    public String addAdditionalInformationAboutUser(@PathVariable String username, Authentication authentication, Model model) {
        if (!authentication.getName().equals(username)) {
            throw new ResourceNotFoundException();
        }
        String[] info = additionalUserInfoService.getDrivingLicenceAndPassportInfoByUsername(username);
        System.out.println(info);
        if (info != null) {
            model.addAttribute("additionalUserInfo", info);
            model.addAttribute("infoExist", true);
        } else {
            String[] noInfo = new String[2];
            noInfo[0] = "Информация в базе отсутствует";
            noInfo[1] = "Информация в базе отсутствует";
            model.addAttribute("additionalUserInfo", noInfo);
            model.addAttribute("infoExist", false);
        }
        return "addinfo";
    }

    @GetMapping("/saveinfo")
    public String saveAdditionalInformationAboutUserPage(@PathVariable String username, Authentication authentication, Model model) {
        if (!authentication.getName().equals(username)) {
            throw new ResourceNotFoundException();
        }
        model.addAttribute("additionalUserInfo", new AdditionalUsersInfo());
        return "saveinfoaboutuser";
    }

    @PostMapping("/addinfo")
    public String saveAdditionalInformationAboutUser(@PathVariable String username, Authentication authentication, AdditionalUsersInfo additionalUsersInfo) {
        if (!authentication.getName().equals(username)) {
            throw new ResourceNotFoundException();
        }
        additionalUserInfoService.saveDrivingLicenceAndPassportInfoByUsername(username, additionalUsersInfo);
        return "redirect:addinfo";
    }

    @GetMapping("/reservations")
    public String viewReservations(@PathVariable String username, Authentication authentication, Model model) {
        if (!authentication.getName().equals(username)) {
            throw new ResourceNotFoundException();
        }
        List<Reservation> reservations = reservationService.findAllByUserLogin(username);
        model.addAttribute("reservations", reservations);
        return "userreservationview";
    }
}
