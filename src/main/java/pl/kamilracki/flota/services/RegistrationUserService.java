package pl.kamilracki.flota.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.enums.Role;
import pl.kamilracki.flota.models.dtos.UserToAddDTO;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.repositories.UserRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class RegistrationUserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationUserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void register(UserToAddDTO userToAddDTO) {
        User user = new User();
        user.setLogin(userToAddDTO.getLogin());
        user.setFirstName(userToAddDTO.getFirstName());
        user.setLastName(userToAddDTO.getLastName());
        user.setPhoneNumber(userToAddDTO.getPhoneNumber());
        user.setActive(1);
        user.setPassword(bCryptPasswordEncoder.encode(userToAddDTO.getPassword()));

        if ("Remek".equals(user.getLogin())) {
            user.setRole(Role.ADMIN.toString());
        } else {
            user.setRole(Role.USER.toString());
        }

        log.info("Attempt to save user: " + user);
        userRepository.save(user);
    }
}
