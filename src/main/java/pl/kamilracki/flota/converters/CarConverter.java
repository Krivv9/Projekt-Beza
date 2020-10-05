package pl.kamilracki.flota.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.kamilracki.flota.models.Car;
import pl.kamilracki.flota.repositories.CarRepository;

public class CarConverter implements Converter<String, Car> {
    @Autowired
    private CarRepository carRepository;
    @Override
    public Car convert(String source) {
        Long id = Long.parseLong(source);
        return carRepository.findCarById(id);
    }
}