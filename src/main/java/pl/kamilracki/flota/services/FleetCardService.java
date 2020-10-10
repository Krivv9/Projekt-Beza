package pl.kamilracki.flota.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.entities.FleetCard;
import pl.kamilracki.flota.repositories.FleetCardRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional

public class FleetCardService {
    private final FleetCardRepository fleetCardRepository;


    public FleetCardService(FleetCardRepository fleetCardRepository) {
        this.fleetCardRepository = fleetCardRepository;
    }

    public void saveCard(FleetCard fleetCard){ fleetCardRepository.save(fleetCard);}

    public List<FleetCard> findAll(){ return fleetCardRepository.findAll();}
}
