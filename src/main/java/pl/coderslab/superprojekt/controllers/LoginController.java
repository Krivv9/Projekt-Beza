package pl.coderslab.superprojekt.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.superprojekt.models.Role;
import pl.coderslab.superprojekt.models.User;
import pl.coderslab.superprojekt.services.UserService;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@Valid User user,Model model) {
        User userExists = userService.findUserByPhoneNumber(user.getPhoneNumber());
        model.addAttribute("user",user);
        if (userExists == null || wrongPassword(userExists, user)) {
            return "users/notLogged";
        }
        return "users/home";
    }

    private boolean wrongPassword(User userExists, User user) {
        return !userExists.getPassword().equals(user.getPassword());
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @GetMapping("/admin/home")
    public String panel() {
        return "admin/home";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access/denied";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult) {
        User userExists = userService.findUserByPhoneNumber(user.getPhoneNumber());
        if (userExists != null) {
            return "redirect:/home";

        }
        if (bindingResult.hasErrors()) {
            return "users/form";
        } else if ("1234567".equals(user.getPhoneNumber())) {
            userService.saveAdmin(user);
        }else {
            userService.saveUser(user);
        }
        return "redirect:/login";
    }

    /*@GetMapping("/admin/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByPhoneNumber(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getPhoneNumber() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }*/
}
