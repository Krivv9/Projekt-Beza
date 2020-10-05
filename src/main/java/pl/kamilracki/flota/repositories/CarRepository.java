package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamilracki.flota.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findCarById(Long id);

}
