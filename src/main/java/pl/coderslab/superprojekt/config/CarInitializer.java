package pl.coderslab.superprojekt.config;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coderslab.superprojekt.model.Car;
import pl.coderslab.superprojekt.model.CarDetails;
import pl.coderslab.superprojekt.service.CarService;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CarInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
   /* Dane do wypełnienia tabeli z autami
   @Autowired
    private CarService carService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        log.info("Starting car initialization ...");

        for(int i = 0;i< 10;i++) {

            Car car = new Car();
            CarDetails carDetails = new CarDetails();
            carDetails.setCarSecurity(faker.dragonBall().character());
            carDetails.setFuelType("ON");
            carDetails.setEngineCapacity(faker.number().randomDouble(2,0,9));
            carDetails.setEngineNumber(faker.number().digits(17));
            carDetails.setChassisNumber(faker.number().digits(17));
            carDetails.setVinNumber(faker.number().digits(17));
            carDetails.setHasGPS("Tak");
            carDetails.setInsuranceCompany(faker.zelda().game());
            carDetails.setLicensePlate(faker.cat().registry());
            carDetails.setModelCar(faker.zelda().character());
            carDetails.setTypeOfCar(faker.witcher().monster());
            carDetails.setNumberOfSeats(faker.number().numberBetween(3,9));
            carDetails.setYearOfProduction(faker.number().numberBetween(1990,2020));
            carDetails.setYearOfFirstRegistration(faker.number().numberBetween(1990,2020));
            car.setCarDetails(carDetails);

            car.setAcPolicyExpireDate(faker.date().future(100, TimeUnit.DAYS));
            car.setOcPolicyExpireDate(faker.date().future(100, TimeUnit.DAYS));
            car.setNextTechnicalInspectionDate(faker.date().future(100, TimeUnit.DAYS));
            car.setComments(faker.zelda().game());
            carService.saveCar(car);
        }

        log.info("... finished car initialization");
    }
*/
}
