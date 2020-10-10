package pl.kamilracki.flota.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.repositories.CarRepository;

public class CarConverter implements Converter<String, Car> {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car convert(String source) {
        Car car = carRepository.findCarById(Long.parseLong(source));
        return car;
    }
}