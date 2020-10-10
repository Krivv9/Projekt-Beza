package pl.kamilracki.flota.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = MonthUse.TABLE)
public class MonthUse extends BaseEntity {
    public final static String TABLE = "cars_month_details";

    @Column(name = "month")
    private String month;

    @Column(name = "kilometers_on_start")
    private Integer numbersOfKilometersOnStartOfMonth;

    @Column(name = "kilometers_on_end")
    private Integer numbersOfKilometersOnEndOfMonth;

    @Column(name = "kilometers_in_month")
    private Integer numbersOfKilometersTraveledInThisMonth;

    @Column(name = "amount_of_fuel")
    private Integer amountOfFuelBought;

    @Column(name = "fuel_consuption")
    private Integer realFuelConsumption;

    @Column(name = "private_fuel")
    private Integer amountOfFuelForPrivateUse;

    @Column(name = "number_of_documents")
    private Integer quantityOfDocuments;

    @ManyToOne
    private Car car;

    @OneToOne
    private User user;

    @Size(max = 300)
    private String comments;
}