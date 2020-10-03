package pl.coderslab.superprojekt.models;

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
    private Integer numbersOfKilometersOnStartOfMonth;
    private Integer numbersOfKilometersOnEndOfMonth;
    private Integer numbersOfKilometersTraveledInThisMonth;
    private Integer amountOfFuelBought;
    private Integer realFuelConsumption;
    private Integer amountOfFuelForPrivateUse;
    private Integer quantityOfDocuments;

    @ManyToOne
    private Car car;

    @OneToOne
    private User user;

    @Size(max = 300)
    private String comments;
}