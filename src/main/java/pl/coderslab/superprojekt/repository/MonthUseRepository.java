package pl.coderslab.superprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.superprojekt.model.MonthUse;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MonthUseRepository extends JpaRepository<MonthUse, Long> {
    MonthUse findById(long id);
}
