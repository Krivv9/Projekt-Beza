package pl.kamilracki.flota.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Principal principal, Model model) {
        String details = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info(details);
        if (principal != null) {
            String login = principal.getName();
            model.addAttribute("userLogin", login);
        }
        return "dashboard";
    }
}
