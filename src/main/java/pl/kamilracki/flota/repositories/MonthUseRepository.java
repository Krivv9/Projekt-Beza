package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilracki.flota.models.entities.MonthUse;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MonthUseRepository extends JpaRepository<MonthUse, Long> {
    MonthUse findById(long id);
}
