package pl.coderslab.superprojekt.service;

import org.springframework.stereotype.Service;
import pl.coderslab.superprojekt.model.MonthUse;
import pl.coderslab.superprojekt.repository.MonthUseRepository;

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
