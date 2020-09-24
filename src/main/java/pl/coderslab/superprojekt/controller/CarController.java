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

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;
    private final MonthUseRepository monthUseRepository;
    private final FleetCardRepository fleetCardRepository;
    private final UserRepository userRepository;



    @ModelAttribute("cards")
    public List<FleetCard> getAllFleetCards() {
        return fleetCardRepository.findAll();
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() { return userRepository.findAll(); }

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
        carRepository.save(car);
        return "redirect:/car/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "car/all";
    }

    @GetMapping("/connect/{id}")
    public String addToCar(@PathVariable long id, Model model) {
        Car car = carRepository.findCarById(id);
        model.addAttribute("car", car);
        return "car/connect";
    }

    @PostMapping("/connect/{id}")
    public String addToCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "car/connect";
        }
        carRepository.save(car);
        return "redirect:/car/all";
    }
}
