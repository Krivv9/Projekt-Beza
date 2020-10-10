package pl.kamilracki.flota.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.models.entities.FleetCard;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.repositories.CarRepository;
import pl.kamilracki.flota.repositories.FleetCardRepository;
import pl.kamilracki.flota.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
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
        userService.save(user);
        return "redirect:/users/all";
    }

    @RequestMapping("/home")
    public String userPan(Principal principal, Model model) {
        if (principal != null) {
            String name = principal.getName();
            model.addAttribute("name", name);
        }
        return "users/home";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/all";
    }
}
