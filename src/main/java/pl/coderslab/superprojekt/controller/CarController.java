package pl.coderslab.superprojekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.MonthUse;
import pl.coderslab.superprojekt.repository.CarRepository;
import pl.coderslab.superprojekt.repository.MonthUseRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;
    private final MonthUseRepository monthUseRepository;

    public CarController(CarRepository carRepository, MonthUseRepository monthUseRepository) {
        this.carRepository = carRepository;
        this.monthUseRepository = monthUseRepository;
    }

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

    @GetMapping("/monthUse")
    public String addMonthUse(Model model) {
        model.addAttribute("monthUse", new MonthUse());
        return "monthUse/monthUse";
    }

    @PostMapping("/monthUse")
    public String saveMonthUse(@Valid MonthUse monthUse, BindingResult result) {
        if (result.hasErrors()) {
            return "monthUse/monthUse";
        }
        monthUseRepository.save(monthUse);
        return "redirect:/monthUse/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "car/all";
    }
}
