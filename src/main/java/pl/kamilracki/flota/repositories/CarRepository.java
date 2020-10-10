package pl.kamilracki.flota.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.models.entities.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findCarById(Long id);
    public Page<Car> findCarByUser(User user, PageRequest pageReq);

}
