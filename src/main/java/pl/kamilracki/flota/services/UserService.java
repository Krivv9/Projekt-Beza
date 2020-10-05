package pl.kamilracki.flota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.Role;
import pl.kamilracki.flota.models.User;
import pl.kamilracki.flota.repositories.RoleRepository;
import pl.kamilracki.flota.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findUserByPhoneNumber(phoneNumber);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Long id) { return userRepository.findUserById(id);
    }

    public void saveAdmin(User admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin.setActive(1);
        Role userRole = roleRepository.findByRole("ROLE_ADMIN");
        admin.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(admin);
    }
}
