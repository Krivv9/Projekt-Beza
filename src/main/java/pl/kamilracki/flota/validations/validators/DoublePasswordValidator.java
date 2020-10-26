package pl.kamilracki.flota.validations.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.kamilracki.flota.models.dtos.UserToAddDTO;
import pl.kamilracki.flota.validations.constrains.DoublePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Slf4j
public class DoublePasswordValidator implements ConstraintValidator<DoublePassword, UserToAddDTO> {

    @Override
    public boolean isValid(UserToAddDTO userToAddDTO, ConstraintValidatorContext context) {
        String password = userToAddDTO.getPassword();
        String doublePassword = userToAddDTO.getDoublePassword();
        log.info("Attempt to valid if password is double");
        boolean isPassDouble = password.equals(doublePassword);

        if (!isPassDouble) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{doublePassword.validation.message}")
                    .addPropertyNode("doublePassword")
                    .addConstraintViolation();
        }
        return isPassDouble;
    }
}
