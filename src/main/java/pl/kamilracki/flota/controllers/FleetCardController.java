package pl.kamilracki.flota.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.models.entities.FleetCard;
import pl.kamilracki.flota.models.entities.GetName;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.services.CarService;
import pl.kamilracki.flota.services.FleetCardService;
import pl.kamilracki.flota.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class FleetCardController {
    private final FleetCardService fleetCardService;
    private final UserService userService;
    private final CarService carService;

    public FleetCardController(FleetCardService fleetCardService, UserService userService, CarService carService) {
        this.fleetCardService = fleetCardService;
        this.userService = userService;
        this.carService = carService;
    }

    @ModelAttribute("cars")
    public List<Car> getAllCars() { return carService.findAll(); }

    @ModelAttribute("users")
    public List<User> getAllUsers() { return userService.findAll(); }

    @ModelAttribute("login")
    public String loginUser() { return GetName.getLoginName();}

    @GetMapping("/add")
    public String addFleetCard(Model model) {
        model.addAttribute("card", new FleetCard());
        return "cards/add";
    }

    @PostMapping("/add")
    public String saveCard(@Valid FleetCard fleetCard, BindingResult result) {
        if (result.hasErrors()) {
            return "cards/add";
        }
        fleetCardService.saveCard(fleetCard);
        return "redirect:/cards/all";
    }

    @GetMapping("add/{id}")
    public String addCardToCar(@PathVariable Long id, Model model) {
        Car car = carService.findById(id);
        FleetCard fleetCard = new FleetCard();
        fleetCard.setCar(car);
        model.addAttribute("card", fleetCard);
        return "cards/form";
    }

    @PostMapping("/add/{id}")
    public String saveCardToCar(@PathVariable Long id, @Valid FleetCard fleetCard, BindingResult result) {
        if (result.hasErrors()) {
            return "cards/form";
        }
        Car updatedCar = carService.findById(fleetCard.getCar().getId());
        fleetCardService.saveCarToCard(fleetCard, updatedCar);
        return "redirect:/cars/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cards", fleetCardService.findAll());
        return "cards/all";
    }
}
