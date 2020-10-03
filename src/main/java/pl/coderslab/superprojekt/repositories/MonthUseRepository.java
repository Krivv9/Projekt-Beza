package pl.coderslab.superprojekt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.superprojekt.models.MonthUse;


public interface MonthUseRepository extends JpaRepository<MonthUse, Long> {
    MonthUse findById(long id);
}
