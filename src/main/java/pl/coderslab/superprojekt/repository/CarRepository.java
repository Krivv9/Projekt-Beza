package pl.coderslab.superprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.superprojekt.model.Car;


import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findCarById(Long id);

}
