package pl.coderslab.superprojekt.enums;

import java.util.Arrays;
import java.util.List;

public enum MONTH {
    ;

    public static List<String> valueOf() {
        final  String[] MONTH = {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};
        return Arrays.asList(MONTH.clone());
    }
}
