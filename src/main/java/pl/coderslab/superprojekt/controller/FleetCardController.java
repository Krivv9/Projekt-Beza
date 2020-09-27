package pl.coderslab.superprojekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.FleetCard;
import pl.coderslab.superprojekt.model.User;
import pl.coderslab.superprojekt.repository.FleetCardRepository;
import pl.coderslab.superprojekt.service.CarService;
import pl.coderslab.superprojekt.service.FleetCardService;
import pl.coderslab.superprojekt.service.UserService;

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
        userService.saveUser(cardUser);
        List<FleetCard> cards = new ArrayList<>();
        cards.add(fleetCard);
        carService.addCard(fleetCard.getCar(),cards);
        carService.addUser(fleetCard.getCar(),cardUser);

        return "redirect:/cards/all";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cards", fleetCardService.findAll());
        return "cards/all";
    }
}
