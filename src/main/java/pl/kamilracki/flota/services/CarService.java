package pl.kamilracki.flota.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.models.entities.FleetCard;
import pl.kamilracki.flota.models.entities.User;
import pl.kamilracki.flota.repositories.CarRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CarService {
    private final CarRepository carRepository;
    private final UserService userService;

    public CarService(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car findById(long id) {
        return carRepository.findCarById(id);
    }

    public List<Car> getCarsList(int page, int size, String sortDir, String sort) {

        PageRequest pageReq
                = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        Page<Car> cars = carRepository.findCarByUser(userService.getCurrentUser(), pageReq);
        return cars.getContent();
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
    public List<Car> findAllWithUser() {
        List<Car> carsWithUser = carRepository.findAll();
        carsWithUser.stream()
                .forEach(car -> Hibernate.initialize(car.getUser()));
        return carsWithUser;
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
