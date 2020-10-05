package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamilracki.flota.models.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);


}
