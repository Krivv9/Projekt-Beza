package pl.kamilracki.flota.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.Car;
import pl.kamilracki.flota.models.FleetCard;
import pl.kamilracki.flota.models.User;
import pl.kamilracki.flota.repositories.CarRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car findById(long id) {
        return carRepository.findCarById(id);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public void addUser(Car car, User user) {
        car.setUser(user);
    }

    public void addCard(Car car, List<FleetCard> cards) {
        car.setFleetCard(cards);
    }

    public List<Car> getAllWithOwners() {
        List<Car> carWithOwners = carRepository.findAll();
        carWithOwners
                .forEach(car -> Hibernate.initialize(car.getFleetCard()));
        carWithOwners
                .forEach(car -> Hibernate.initialize(car.getUser()));
        return carWithOwners;
    }
}
