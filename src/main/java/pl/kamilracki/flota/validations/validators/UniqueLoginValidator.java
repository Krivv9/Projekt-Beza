package pl.kamilracki.flota.validations.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.kamilracki.flota.repositories.UserRepository;
import pl.kamilracki.flota.validations.constrains.UniqueLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Component
@Slf4j
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String valueToValid, ConstraintValidatorContext context) {
        log.info("Attempt to valid unique login: " + valueToValid);
        return !userRepository.existsByLogin(valueToValid);
    }
}
