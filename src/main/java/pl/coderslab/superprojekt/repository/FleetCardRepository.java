package pl.coderslab.superprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.superprojekt.model.FleetCard;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FleetCardRepository extends JpaRepository<FleetCard, Long> {
}
