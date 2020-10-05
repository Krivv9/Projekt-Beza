package pl.kamilracki.flota.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamilracki.flota.models.Car;
import pl.kamilracki.flota.models.FleetCard;
import pl.kamilracki.flota.models.MonthUse;
import pl.kamilracki.flota.models.User;
import pl.kamilracki.flota.services.CarService;
import pl.kamilracki.flota.services.FleetCardService;
import pl.kamilracki.flota.services.MonthUseService;
import pl.kamilracki.flota.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final MonthUseService monthUseService;
    private final FleetCardService fleetCardService;
    private final UserService userService;

    @ModelAttribute("monthUses")
    public List<MonthUse> getAllUses() { return  monthUseService.findAll(); }

    @ModelAttribute("cards")
    public List<FleetCard> getAllFleetCards() {
        return fleetCardService.findAll();
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() { return userService.findAll(); }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        return "cars/form";
    }

    @PostMapping("/add")
    public String saveCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/form";
        }
        carService.saveCar(car);
        return "redirect:/cars/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "cars/all";
    }

    @GetMapping("/connect/{id}")
    public String addToCar(@PathVariable long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "cars/connect";
    }

    @PostMapping("/connect/{id}")
    public String addToCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/all";
        }
        Car updatedCar = carService.findById(car.getId());
        updatedCar.setFleetCard(car.getFleetCard());
        updatedCar.setUser(car.getUser());
        carService.saveCar(updatedCar);
        return "redirect:/cars/all";
    }
}
