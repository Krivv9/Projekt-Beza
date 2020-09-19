package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = Car.TABLE)
public class Car {
    public final static String TABLE = "cars";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelCar;

    @Column(nullable = false)
    private String typeOfCar;

    @Size(min = 2,max = 9)
    @Column(nullable = false)
    private String licensePlate;

    @Size(min = 17, max = 17)
    @Column(nullable = false)
    private String vinNumber;

    @Column(nullable = false)
    private String chassisNumber;

    @Column(nullable = false)
    private String engineNumber;

    @Column(nullable = false)
    private String yearOfProduction;

    @Column(nullable = false)
    private String engineCapacity;

    @Column(nullable = false)
    private String numberOfSeats;

    @Column(nullable = false)
    private String fuelType;

    private Date ocPolicyExpireDate;

    public void setOcPolicyExpireDate(String ocPolicyExpireDate){
        try {
            this.ocPolicyExpireDate = new SimpleDateFormat("yyyy-MM-dd").parse(ocPolicyExpireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Date acPolicyExpireDate;

    public void setAcPolicyExpireDate(String acPolicyExpireDate){
        try {
            this.acPolicyExpireDate = new SimpleDateFormat("yyyy-MM-dd").parse(acPolicyExpireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String insuranceCompany;
    private String hasGPS;
    private String carSecurity;

    private Date nextTechnicalInspectionDate;

    public void setNextTechnicalInspectionDate(String nextTechnicalInspectionDate) {
        try {
        this.nextTechnicalInspectionDate = new SimpleDateFormat("yyyy-MM-dd").parse(nextTechnicalInspectionDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    }

    @Column(nullable = false)
    private String yearOfFirstRegistration;

    @Size(max = 300)
    private String comments;

    @OneToOne
    private MonthUse monthUse;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "car")
    private List<FleetCard> fleetCard = new ArrayList<>();
}
