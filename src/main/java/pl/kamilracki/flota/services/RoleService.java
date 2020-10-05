package pl.kamilracki.flota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.Role;
import pl.kamilracki.flota.repositories.RoleRepository;

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
