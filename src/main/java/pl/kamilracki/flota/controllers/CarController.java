package pl.kamilracki.flota.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamilracki.flota.models.entities.*;
import pl.kamilracki.flota.services.CarService;
import pl.kamilracki.flota.services.FleetCardService;
import pl.kamilracki.flota.services.MonthUseService;
import pl.kamilracki.flota.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final MonthUseService monthUseService;
    private final FleetCardService fleetCardService;
    private final UserService userService;

    public CarController(CarService carService, MonthUseService monthUseService, FleetCardService fleetCardService, UserService userService) {
        this.carService = carService;
        this.monthUseService = monthUseService;
        this.fleetCardService = fleetCardService;
        this.userService = userService;
    }

    @ModelAttribute("monthUses")
    public List<MonthUse> getAllUses() { return  monthUseService.findAll(); }

    @ModelAttribute("cards")
    public List<FleetCard> getAllFleetCards() {
        return fleetCardService.findAll();
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() { return userService.findAll(); }

    @ModelAttribute("login")
    public String loginUser() { return GetName.getLoginName();}

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        return "cars/form";
    }

    @PostMapping("/add")
    public String saveCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/form";
        }
        carService.saveCar(car);
        return "cars/allDetails";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars/showAll";
    }

    @RequestMapping("/allDetails/{id}")
    public String getAllDetails(@PathVariable long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "cars/allDetails";
    }

    @GetMapping("/connect/{id}")
    public String addToCar(@PathVariable long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "cars/connect";
    }

    @PostMapping("/connect/{id}")
    public String addToCar(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/cars/allDetails/" + car.getId();
        }
        Car updatedCar = carService.findById(car.getId());
        updatedCar.setUser(car.getUser());
        carService.saveCar(updatedCar);
        return "redirect:/cars/all";
    }

    /*private CarShowDTO convertToDto(Post post) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postDto.setSubmissionDate(post.getSubmissionDate(),
                userService.getCurrentUser().getPreference().getTimezone());
        return postDto;
    }

    private Post convertToEntity(PostDto postDto) throws ParseException {
        Post post = modelMapper.map(postDto, Post.class);
        post.setSubmissionDate(postDto.getSubmissionDateConverted(
                userService.getCurrentUser().getPreference().getTimezone()));

        if (postDto.getId() != null) {
            Post oldPost = postService.getPostById(postDto.getId());
            post.setRedditID(oldPost.getRedditID());
            post.setSent(oldPost.isSent());
        }
        return post;
    }*/
}
