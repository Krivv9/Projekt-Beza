package pl.kamilracki.flota.models;

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
public class Car extends BaseEntity{
    public final static String TABLE = "cars";

    @Column(name = "expire_date_oc", nullable = false)
    private Date ocPolicyExpireDate;

    //public void setOcPolicyExpireDate(Date ocPolicyExpireDate) {this.ocPolicyExpireDate = ocPolicyExpireDate;}
    //public void setNextTechnicalInspectionDate(Date nextTechnicalInspectionDate) { this.nextTechnicalInspectionDate = nextTechnicalInspectionDate; }
    //public void setAcPolicyExpireDate(Date acPolicyExpireDate) {this.acPolicyExpireDate = acPolicyExpireDate;}

    public void setOcPolicyExpireDate(String ocPolicyExpireDate) {
        try {
            this.ocPolicyExpireDate = new SimpleDateFormat("yyyy-MM-dd").parse(ocPolicyExpireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Column(name = "expire_date_ac", nullable = false)
    private Date acPolicyExpireDate;

    public void setAcPolicyExpireDate(String acPolicyExpireDate) {
        try {
            this.acPolicyExpireDate = new SimpleDateFormat("yyyy-MM-dd").parse(acPolicyExpireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }    }

    @Column(name = "next_tech_insp_date")
    private Date nextTechnicalInspectionDate;

    public void setNextTechnicalInspectionDate(String nextTechnicalInspectionDate) {
        try {
            this.nextTechnicalInspectionDate = new SimpleDateFormat("yyyy-MM-dd").parse(nextTechnicalInspectionDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Size(max = 300)
    @Column(name = "comments")
    private String comments;

    private CarDetails carDetails;

    @OneToMany(mappedBy = "car")
    private List<MonthUse> monthUses;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "car")
    private List<FleetCard> fleetCard = new ArrayList<>();
}
