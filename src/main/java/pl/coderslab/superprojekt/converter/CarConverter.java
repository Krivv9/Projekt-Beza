package pl.coderslab.superprojekt.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.repository.CarRepository;

public class CarConverter implements Converter<String, Car> {
    @Autowired
    private CarRepository carRepository;
    @Override
    public Car convert(String source) {
        Long id = Long.parseLong(source);
        return carRepository.findCarById(id);
    }
}