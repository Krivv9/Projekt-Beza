package pl.coderslab.superprojekt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.superprojekt.models.Role;
import pl.coderslab.superprojekt.repositories.RoleRepository;

import javax.transaction.Transactional;

@Service
@Transactional

public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
