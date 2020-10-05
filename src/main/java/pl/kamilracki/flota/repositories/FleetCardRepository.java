package pl.kamilracki.flota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamilracki.flota.models.FleetCard;


public interface FleetCardRepository extends JpaRepository<FleetCard, Long> {
}
