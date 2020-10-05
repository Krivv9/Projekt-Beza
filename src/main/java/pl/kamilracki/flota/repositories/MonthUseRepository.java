package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamilracki.flota.models.MonthUse;


public interface MonthUseRepository extends JpaRepository<MonthUse, Long> {
    MonthUse findById(long id);
}
