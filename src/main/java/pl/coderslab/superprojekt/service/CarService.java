package pl.coderslab.superprojekt.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.User;
import pl.coderslab.superprojekt.repository.CarRepository;

import javax.transaction.Transactional;
import java.util.List;

@NoArgsConstructor
@Service
@Transactional
public class CarService {
    private CarRepository carRepository;

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car findById(long id) {
        return carRepository.findCarById(id);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public void addOwner(Car car, User owner) {
        car.setOwner(owner);
    }

    public List<Car> getAllWithOwners() {
        List<Car> carWithOwners = carRepository.findAll();
        carWithOwners.stream()
                .forEach(car -> Hibernate.initialize(car.getOwner()));
        return carWithOwners;
    }
}
