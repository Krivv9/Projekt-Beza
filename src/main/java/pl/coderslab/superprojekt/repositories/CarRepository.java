package pl.coderslab.superprojekt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.superprojekt.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findCarById(Long id);

}
