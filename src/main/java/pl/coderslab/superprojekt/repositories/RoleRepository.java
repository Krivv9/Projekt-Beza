package pl.coderslab.superprojekt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.superprojekt.models.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);


}
