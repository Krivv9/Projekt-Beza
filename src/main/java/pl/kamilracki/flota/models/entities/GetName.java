package pl.kamilracki.flota.models.entities;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class GetName {

    public static String getLoginName() {
        String name;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            name = auth.getName();
        } else return "Brak loginu";
        return name;
    }
}
