package pl.coderslab.superprojekt.controllers;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.enums.MONTH;
import pl.coderslab.superprojekt.models.Car;
import pl.coderslab.superprojekt.models.MonthUse;
import pl.coderslab.superprojekt.services.CarService;
import pl.coderslab.superprojekt.services.MonthUseService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/monthUses")
public class MonthUseController {
    private final MonthUseService monthUseService;
    private final CarService carService;

    @ModelAttribute("months")
    public List<String> getAllMonths(){return MONTH.valueOf();}


    @ModelAttribute("cars")
    public List<Car> getAllUsers() {
        return carService.findAll();
    }

    @GetMapping("/add/{id}")
    public String addMonthUse(@PathVariable("id") Long id, Model model) {
        Car car = carService.findById(id);
        Hibernate.initialize(car.getUser());
        Hibernate.initialize(car.getCarDetails());
        model.addAttribute("monthUse", new MonthUse());
        model.addAttribute("car", car);
        return "monthUses/form";
    }

    @PostMapping("/add/{id}")
    public String saveMonthUse(@Valid MonthUse monthUse, BindingResult result) {
        if (result.hasErrors()) {
            return "monthUses/form";
        }
        int start = monthUse.getNumbersOfKilometersOnStartOfMonth();
        int end = monthUse.getNumbersOfKilometersOnEndOfMonth();

        monthUse.setNumbersOfKilometersTraveledInThisMonth(end-start);
        monthUse.setCar(monthUse.getCar());
        monthUseService.saveMonthUse(monthUse);
        return "redirect:/monthUses/all/{id}";
    }

    @RequestMapping("/all/{id}")
    public String getAll(@PathVariable Long id, Model model) {
        Car car = carService.findById(id);
        String plateLicense = car.getCarDetails().getLicensePlate();
        String userName = car.getUser().getFullName();
        model.addAttribute("monthUse", monthUseService.findAll());
        model.addAttribute("userName", userName);
        model.addAttribute("plateLicense", plateLicense);
        return "monthUses/all";
    }
}
