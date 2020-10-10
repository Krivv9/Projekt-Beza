package pl.kamilracki.flota.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.kamilracki.flota.models.entities.Car;
import pl.kamilracki.flota.repositories.CarRepository;

@RequiredArgsConstructor
public class CarConverter implements Converter<String, Car> {

    private CarRepository carRepository;
    @Override
    public Car convert(String source) {
        Long id = Long.parseLong(source);
        return carRepository.findCarById(id);
    }
}