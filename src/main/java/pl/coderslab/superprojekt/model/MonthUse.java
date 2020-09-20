package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = MonthUse.TABLE)
public class MonthUse extends BaseEntity{
    public final static String TABLE = "cars_month_details";

    private String month;
    private String numbersOfKilometersOnStartOfMonth;
    private String numbersOfKilometersOnEndOfMonth;
    private Integer numbersOfKilometersTraveledInThisMonth;
    private String amountOfFuelBought;
    private String realFuelConsumption;
    private String amountOfFuelForPrivateUse;
    private String quantityOfDocuments;

    @OneToOne
    private Car car;

    @OneToOne
    private User owner;

    @Size(max = 300)
    private String comments;
}