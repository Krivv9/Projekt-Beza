package pl.kamilracki.flota.models.dtos;

import lombok.Data;
import pl.kamilracki.flota.validations.constrains.DoublePassword;
import pl.kamilracki.flota.validations.constrains.UniqueLogin;
import pl.kamilracki.flota.validations.constrains.UniquePhoneNumber;

import javax.validation.constraints.NotBlank;

@Data
@DoublePassword
public class UserToAddDTO {

    @NotBlank
    @UniqueLogin
    private String login;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @UniquePhoneNumber
    private String phoneNumber;

    @NotBlank
    private String password;

    @NotBlank
    private String doublePassword;


    public String getFullName() {
        return firstName + " " + lastName;
    }
}
