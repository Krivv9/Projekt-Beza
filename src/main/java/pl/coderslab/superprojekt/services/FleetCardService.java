package pl.coderslab.superprojekt.services;

import org.springframework.stereotype.Service;
import pl.coderslab.superprojekt.models.FleetCard;
import pl.coderslab.superprojekt.repositories.FleetCardRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class FleetCardService {
    private FleetCardRepository fleetCardRepository;

    public FleetCardService(FleetCardRepository fleetCardRepository) {
        this.fleetCardRepository = fleetCardRepository;
    }

    public void saveCard(FleetCard fleetCard){ fleetCardRepository.save(fleetCard);}

    public List<FleetCard> findAll(){ return fleetCardRepository.findAll();}
}
