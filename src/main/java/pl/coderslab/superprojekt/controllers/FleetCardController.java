package pl.coderslab.superprojekt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.superprojekt.models.Car;
import pl.coderslab.superprojekt.models.FleetCard;
import pl.coderslab.superprojekt.models.User;
import pl.coderslab.superprojekt.services.CarService;
import pl.coderslab.superprojekt.services.FleetCardService;
import pl.coderslab.superprojekt.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cards")
public class FleetCardController {
    private final FleetCardService fleetCardService;
    private final UserService userService;
    private final CarService carService;

    @ModelAttribute("cars")
    public List<Car> getAllCars() { return carService.findAll(); }

    @ModelAttribute("users")
    public List<User> getAllUsers() { return userService.findAll(); }

    @GetMapping("/add")
    public String addFleetCard(Model model) {
        model.addAttribute("card", new FleetCard());
        return "cards/form";
    }

    @PostMapping("/add")
    public String saveCard(@Valid FleetCard fleetCard, BindingResult result) {
        if (result.hasErrors()) {
            return "cards/form";
        }
        fleetCardService.saveCard(fleetCard);
        User cardUser = fleetCard.getUser();
        cardUser.setCar(fleetCard.getCar());
        cardUser.setFleetCard(fleetCard);
        List<FleetCard> cards = new ArrayList<>();
        cards.add(fleetCard);
        carService.addCard(fleetCard.getCar(),cards);
        carService.addUser(fleetCard.getCar(),cardUser);

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
    public String saveCardToCar(@Valid FleetCard fleetCard, BindingResult result) {
        if (result.hasErrors()) {
            return "cards/form";
        }
        fleetCardService.saveCard(fleetCard);
        User cardUser = fleetCard.getUser();
        cardUser.setCar(fleetCard.getCar());
        cardUser.setFleetCard(fleetCard);
        List<FleetCard> cards = new ArrayList<>();
        cards.add(fleetCard);
        carService.addCard(fleetCard.getCar(), cards);
        carService.addUser(fleetCard.getCar(), cardUser);

        return "redirect:/cards/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cards", fleetCardService.findAll());
        return "cards/all";
    }
}
