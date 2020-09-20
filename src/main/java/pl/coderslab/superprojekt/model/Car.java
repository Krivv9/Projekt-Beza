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
public class Car extends BaseEntity{
    public final static String TABLE = "cars";

    @Column(name = "expire_date_oc", nullable = false)
    private Date ocPolicyExpireDate;

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
        }
    }

    @Column(name = "next_tech_insp_date", nullable = false)
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

    @OneToOne
    private MonthUse monthUse;

    @OneToOne
    private User owner;

    @OneToMany(mappedBy = "car")
    private List<FleetCard> fleetCard = new ArrayList<>();
}
