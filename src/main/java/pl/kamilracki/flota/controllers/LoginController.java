package pl.kamilracki.flota.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamilracki.flota.models.User;
import pl.kamilracki.flota.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

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

    @RequestMapping("/admin/home")
    public String panel(Principal principal, Model model) {
        if (principal != null) {
            String name = userService.findUserByPhoneNumber(principal.getName()).getFullName();
            model.addAttribute("name", name);
        }
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
        return "redirect:/users/login";
    }
}
