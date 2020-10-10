package pl.kamilracki.flota.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@Embeddable
public class CarDetails {
    @NotBlank
    @Column(name = "model",nullable = false)
    private String modelCar;

    @NotBlank
    @Column(name = "type",nullable = false)
    private String typeOfCar;

    @NotBlank
    @Column(name = "license_plate",nullable = false)
    private String licensePlate;

    @NotBlank
    @Column(name = "vin_number",nullable = false)
    private String vinNumber;

    @NotBlank
    @Column(name = "chassis_number",nullable = false)
    private String chassisNumber;

    @NotBlank
    @Column(name = "engine_number",nullable = false)
    private String engineNumber;

    @NotBlank
    @Column(name = "year_of_production",nullable = false)
    private Integer yearOfProduction;

    @NotBlank
    @Column(name = "engine_capacity",nullable = false)
    private Double engineCapacity;

    @NotBlank
    @Column(name = "number_of_seats",nullable = false)
    private Integer numberOfSeats;

    @NotBlank
    @Column(name = "fuel_type",nullable = false)
    private String fuelType;

    @NotBlank
    @Column(name = "gps",nullable = false)
    private String hasGPS;

    @NotBlank
    @Column(name = "security",nullable = false)
    private String carSecurity;

    @NotBlank
    @Column(name = "year_first_reg",nullable = false)
    private Integer yearOfFirstRegistration;

    @NotBlank
    @Column(name = "insurance_company",nullable = false)
    private String insuranceCompany;


}
