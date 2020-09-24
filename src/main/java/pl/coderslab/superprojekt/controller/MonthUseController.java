package pl.coderslab.superprojekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.superprojekt.model.MonthUse;
import pl.coderslab.superprojekt.repository.MonthUseRepository;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/monthUse")
public class MonthUseController {
    private final MonthUseRepository monthUseRepository;

    @GetMapping("/add")
    public String addMonthUse(Model model) {
        model.addAttribute("monthUse", new MonthUse());
        return "monthUse/form";
    }

    @PostMapping("/add")
    public String saveMonthUse(@Valid MonthUse monthUse, BindingResult result) {
        if (result.hasErrors()) {
            return "monthUse/form";
        }
        int start = Integer.parseInt(monthUse.getNumbersOfKilometersOnStartOfMonth());
        int end = Integer.parseInt(monthUse.getNumbersOfKilometersOnEndOfMonth());

        monthUse.setNumbersOfKilometersTraveledInThisMonth(end-start);
        monthUseRepository.save(monthUse);
        return "redirect:/monthUse/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("monthUse", monthUseRepository.findAll());
        return "monthUse/all";
    }
}
