package pl.coderslab.superprojekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.FleetCard;
import pl.coderslab.superprojekt.model.MonthUse;
import pl.coderslab.superprojekt.model.User;
import pl.coderslab.superprojekt.repository.CarRepository;
import pl.coderslab.superprojekt.repository.FleetCardRepository;
import pl.coderslab.superprojekt.repository.MonthUseRepository;
import pl.coderslab.superprojekt.repository.UserRepository;
import pl.coderslab.superprojekt.service.CarService;
import pl.coderslab.superprojekt.service.FleetCardService;
import pl.coderslab.superprojekt.service.MonthUseService;
import pl.coderslab.superprojekt.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final MonthUseService monthUseService;
    private final FleetCardService fleetCardService;
    private final UserService userService;



    @ModelAttribute("cards")
    public List<FleetCard> getAllFleetCards() {
        return fleetCardService.findAll();
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() { return userService.findAll(); }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        return "car/form";
    }

    @PostMapping("/add")
    public String saveCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "car/form";
        }
        carService.saveCar(car);
        return "redirect:/car/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car/all";
    }

    @GetMapping("/connect/{id}")
    public String addToCar(@PathVariable long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "car/connect";
    }

    @PostMapping("/connect/{id}")
    public String addToCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "car/connect";
        }
        Car updatedCar = carService.findById(car.getId());
        carService.addOwner(updatedCar,car.getOwner());
        carService.addCard(updatedCar,car.getFleetCard());
        carService.saveCar(updatedCar);
        return "redirect:/car/all";
    }
}
