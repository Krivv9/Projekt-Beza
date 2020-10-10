package pl.kamilracki.flota.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kamilracki.flota.models.dtos.UserToAddDTO;
import pl.kamilracki.flota.services.RegistrationUserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {

    private final RegistrationUserService registrationUserService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userToAdd", new UserToAddDTO());
        return "registration/newUser";
    }

    @PostMapping("/registration")
    public String createNewUser(@ModelAttribute("userToAdd") @Valid UserToAddDTO userToAdd, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration/newUser";
        }
        registrationUserService.register(userToAdd);
        return "dashboard";
    }
}
