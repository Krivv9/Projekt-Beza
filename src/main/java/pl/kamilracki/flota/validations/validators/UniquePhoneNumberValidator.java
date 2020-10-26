package pl.kamilracki.flota.validations.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.kamilracki.flota.repositories.UserRepository;
import pl.kamilracki.flota.validations.constrains.UniquePhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Slf4j
@RequiredArgsConstructor
public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
    private final UserRepository userRepository;

    public boolean isValid(String valueToValid, ConstraintValidatorContext context) {
        log.info("Attempt to valid unique phone number: " + valueToValid);
        return !userRepository.existsByPhoneNumber(valueToValid);
    }
}
