package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Getter @Setter
@Embeddable
public class CarDetails {
    @Column(name = "model",nullable = false)
    private String modelCar;

    @Column(name = "type",nullable = false)
    private String typeOfCar;

    @Size(min = 2,max = 9)
    @Column(name = "license_plate",nullable = false)
    private String licensePlate;

    @Size(min = 17, max = 17)
    @Column(name = "vin_number",nullable = false)
    private String vinNumber;

    @Column(name = "chassis_number",nullable = false)
    private String chassisNumber;

    @Column(name = "engine_number",nullable = false)
    private String engineNumber;

    @Column(name = "year_of_production",nullable = false)
    private String yearOfProduction;

    @Column(name = "engine_capacity",nullable = false)
    private String engineCapacity;

    @Column(name = "number_of_seats",nullable = false)
    private String numberOfSeats;

    @Column(name = "fuel_type",nullable = false)
    private String fuelType;

    @Column(name = "gps",nullable = false)
    private String hasGPS;

    @Column(name = "security",nullable = false)
    private String carSecurity;

    @Column(name = "year_first_reg",nullable = false)
    private String yearOfFirstRegistration;

    @Column(name = "insurance_company",nullable = false)
    private String insuranceCompany;


}
