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
import pl.coderslab.superprojekt.service.MonthUseService;

import javax.validation.Valid;
import java.text.ParseException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/monthUses")
public class MonthUseController {
    private final MonthUseService monthUseService;

    @GetMapping("/add")
    public String addMonthUse(Model model) {
        model.addAttribute("monthUse", new MonthUse());
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
