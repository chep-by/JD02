package by.itacademy.controller;

import by.itacademy.entity.User;
import by.itacademy.exceptions.UserExistException;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationAndRegistrationController {

    private UserService userService;

    @Autowired
    public AuthenticationAndRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationForm(User user, Model model) {
        try {
            userService.newUserRegistration(user);
        } catch (UserExistException e) {
            model.addAttribute("userExist", e.getMessage());
        }
        return "registration";
    }
}
