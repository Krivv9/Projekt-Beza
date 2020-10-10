package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamilracki.flota.models.entities.FleetCard;

@Repository
public interface FleetCardRepository extends JpaRepository<FleetCard, Long> {
}
