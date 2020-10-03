package pl.coderslab.superprojekt.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.superprojekt.models.User;
import pl.coderslab.superprojekt.repositories.UserRepository;

public class UserConverter implements Converter<String, User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String source) {
        Long id = Long.parseLong(source);
        return userRepository.findUserById(id);
    }

}
