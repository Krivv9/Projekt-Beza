package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilracki.flota.models.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findUserByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumber(String phoneNumber);
}
