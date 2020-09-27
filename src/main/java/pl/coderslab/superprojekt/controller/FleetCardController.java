package pl.coderslab.superprojekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.superprojekt.model.FleetCard;
import pl.coderslab.superprojekt.repository.FleetCardRepository;
import pl.coderslab.superprojekt.service.FleetCardService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/card")
public class FleetCardController {
    private final FleetCardService fleetCardService;

    @GetMapping("/add")
    public String addFleetCard(Model model) {
        model.addAttribute("card", new FleetCard());
        return "card/form";
    }

    @PostMapping("/add")
    public String saveCard(@Valid FleetCard fleetCard, BindingResult result) {
        if (result.hasErrors()) {
            return "card/form";
        }
        fleetCardService.saveCard(fleetCard);
        return "redirect:/card/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cards", fleetCardService.findAll());
        return "card/all";
    }
}
