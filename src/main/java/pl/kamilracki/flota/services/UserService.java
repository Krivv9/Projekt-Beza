package pl.kamilracki.flota.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.repositories.UserRepository;

import javax.security.auth.message.AuthException;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findUserByPhoneNumber(phoneNumber);
    }
    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
    public User getCurrentUser() {
        String login;
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            login = auth.getName();
            user = userRepository.findUserByLogin(login);
        }
        return user;
    };

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Long id) { return userRepository.findUserById(id);
    }


    public User save(User user) {
        return userRepository.save(user);
    }
}
