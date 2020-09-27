package pl.coderslab.superprojekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.FleetCard;
import pl.coderslab.superprojekt.model.User;
import pl.coderslab.superprojekt.repository.CarRepository;
import pl.coderslab.superprojekt.repository.FleetCardRepository;
import pl.coderslab.superprojekt.repository.UserRepository;
import pl.coderslab.superprojekt.service.UserService;

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

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/all";
    }
}
