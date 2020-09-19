package pl.coderslab.superprojekt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.superprojekt.model.Car;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
}
