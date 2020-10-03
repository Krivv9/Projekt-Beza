package pl.coderslab.superprojekt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.superprojekt.models.FleetCard;


public interface FleetCardRepository extends JpaRepository<FleetCard, Long> {
}
