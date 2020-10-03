package pl.coderslab.superprojekt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.models.Car;
import pl.coderslab.superprojekt.models.FleetCard;
import pl.coderslab.superprojekt.models.User;
import pl.coderslab.superprojekt.repositories.CarRepository;
import pl.coderslab.superprojekt.repositories.FleetCardRepository;
import pl.coderslab.superprojekt.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CarRepository carRepository;
    private final FleetCardRepository fleetCardRepository;

    @ModelAttribute("cards")
    public List<FleetCard> getAllFleetCards() {
        return fleetCardRepository.findAll();
    }

    @ModelAttribute("cars")
    public List<Car> getAllUsers() {
        return carRepository.findAll();
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping("/add")
    public String saveCar(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/form";
        }
        userService.saveUser(user);
        return "redirect:/users/all";
    }

    @RequestMapping("/home")
    public String userPanel(Model model) {
        model.getAttribute("user");
        return "users/home";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/all";
    }
}
