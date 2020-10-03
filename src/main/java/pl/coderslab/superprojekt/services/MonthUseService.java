package pl.coderslab.superprojekt.services;

import org.springframework.stereotype.Service;
import pl.coderslab.superprojekt.models.MonthUse;
import pl.coderslab.superprojekt.repositories.MonthUseRepository;

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
