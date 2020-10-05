package pl.kamilracki.flota.services;

import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.MonthUse;
import pl.kamilracki.flota.repositories.MonthUseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MonthUseService {
    private MonthUseRepository monthUseRepository;

    public MonthUseService(MonthUseRepository monthUseRepository) {
        this.monthUseRepository = monthUseRepository;
    }

    public List<MonthUse> findAll() { return monthUseRepository.findAll();}

    public void saveMonthUse(MonthUse monthUse) { monthUseRepository.save(monthUse);}
}
