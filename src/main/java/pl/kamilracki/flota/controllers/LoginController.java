package pl.kamilracki.flota.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamilracki.flota.models.entities.GetName;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    @ModelAttribute("login")
    public String loginUser() { return GetName.getLoginName();}

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @RequestMapping("/admin/home")
    public String panel(Principal principal, Model model) {
        if (principal != null) {
            String name = principal.getName();
            model.addAttribute("name", name);
        }
        return "admin/home";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access/denied";
    }

    @GetMapping("/logout-confirm")
    public String confirmLogout() {
        return "/login/logout-confirmation";
    }
}
