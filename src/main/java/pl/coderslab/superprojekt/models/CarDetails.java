package pl.coderslab.superprojekt.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter @Setter
@Embeddable
public class CarDetails {
    @Column(name = "model",nullable = false)
    private String modelCar;

    @Column(name = "type",nullable = false)
    private String typeOfCar;

    @Column(name = "license_plate",nullable = false)
    private String licensePlate;

    @Column(name = "vin_number",nullable = false)
    private String vinNumber;

    @Column(name = "chassis_number",nullable = false)
    private String chassisNumber;

    @Column(name = "engine_number",nullable = false)
    private String engineNumber;

    @Column(name = "year_of_production",nullable = false)
    private Integer yearOfProduction;

    @Column(name = "engine_capacity",nullable = false)
    private Double engineCapacity;

    @Column(name = "number_of_seats",nullable = false)
    private Integer numberOfSeats;

    @Column(name = "fuel_type",nullable = false)
    private String fuelType;

    @Column(name = "gps",nullable = false)
    private String hasGPS;

    @Column(name = "security",nullable = false)
    private String carSecurity;

    @Column(name = "year_first_reg",nullable = false)
    private Integer yearOfFirstRegistration;

    @Column(name = "insurance_company",nullable = false)
    private String insuranceCompany;


}
