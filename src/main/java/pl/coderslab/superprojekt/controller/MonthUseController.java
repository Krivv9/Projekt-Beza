package pl.coderslab.superprojekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.MonthUse;
import pl.coderslab.superprojekt.service.CarService;
import pl.coderslab.superprojekt.service.MonthUseService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/monthUses")
public class MonthUseController {
    private final MonthUseService monthUseService;
    private final CarService carService;

    @ModelAttribute("cars")
    public List<Car> getAllUsers() {
        return carService.findAll();
    }

    @GetMapping("/add/{id}")
    public String addMonthUse(@PathVariable("id") Long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("monthUse", new MonthUse());
        model.addAttribute("car", car);
        return "monthUses/form";
    }

    @PostMapping("/add")
    public String saveMonthUse(@Valid MonthUse monthUse, BindingResult result) {
        if (result.hasErrors()) {
            return "monthUses/form";
        }
        int start = Integer.parseInt(monthUse.getNumbersOfKilometersOnStartOfMonth());
        int end = Integer.parseInt(monthUse.getNumbersOfKilometersOnEndOfMonth());

        monthUse.setNumbersOfKilometersTraveledInThisMonth(end-start);
        monthUseService.saveMonthUse(monthUse);
        return "redirect:/monthUses/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("monthUse", monthUseService.findAll());
        return "monthUses/all";
    }
}
