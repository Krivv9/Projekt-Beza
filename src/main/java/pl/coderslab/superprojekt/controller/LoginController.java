package pl.coderslab.superprojekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.User;
import pl.coderslab.superprojekt.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping({"/", "/login"})
    public String login(Model model){
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping({"/", "/login"})
    public String login(@Valid User user) {
        User userExists = userService.findUserByPhoneNumber(user.getPhoneNumber());
        if (userExists != null) {
            return "user/all";
        }
        return "user/login";
    }


    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult) {
        User userExists = userService.findUserByPhoneNumber(user.getPhoneNumber());
        if (userExists != null) {
            bindingResult
                    .rejectValue("phoneNumber", "error.user",
                            "There is already a user registered with the phone number provided");
        }
        if (bindingResult.hasErrors()) {
            return "user/form";
        } else {
            userService.saveUser(user);
        }
        return "redirect:/user/login";
    }

    @GetMapping("/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByPhoneNumber(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getPhoneNumber() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
