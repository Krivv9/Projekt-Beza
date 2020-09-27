package pl.coderslab.superprojekt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.superprojekt.model.FleetCard;
import pl.coderslab.superprojekt.repository.FleetCardRepository;

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
