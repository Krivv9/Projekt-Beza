package pl.kamilracki.flota.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.models.entities.FleetCard;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.repositories.FleetCardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional

public class FleetCardService {
    private final FleetCardRepository fleetCardRepository;


    public FleetCardService(FleetCardRepository fleetCardRepository) {
        this.fleetCardRepository = fleetCardRepository;
    }

    public void saveCarToCard(FleetCard fleetCard, Car updatedCar){
        List<FleetCard> cards = new ArrayList<>();
        cards.add(fleetCard);
        updatedCar.setFleetCard(cards);
        if (updatedCar.getUser() != null) {
            User user = updatedCar.getUser();
            fleetCard.setUser(user);
        }
        fleetCardRepository.save(fleetCard);
    }

    public List<FleetCard> findAll(){ return fleetCardRepository.findAll();}

    public void saveCard(FleetCard fleetCard) {
        fleetCardRepository.save(fleetCard);
    }
}
