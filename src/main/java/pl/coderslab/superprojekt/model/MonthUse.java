package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = MonthUse.TABLE)
public class MonthUse {
    public final static String TABLE = "cars_month_details";

    @Id
    @GeneratedValue
    private Long id;

    private String month;
    private Integer numbersOfKilometersOnStartOfMonth;
    private Integer numbersOfKilometersOnEndOfMonth;
    private Integer numbersOfKilometersTraveledInThisMonth;
    private Integer amountOfFuelBought;
    private Integer realFuelConsumption;
    private Integer amountOfFuelForPrivateUse;
    private Integer quantityOfDocuments;

    @OneToOne
    private Car car;

    @Size(max = 300)
    private String comments;
}