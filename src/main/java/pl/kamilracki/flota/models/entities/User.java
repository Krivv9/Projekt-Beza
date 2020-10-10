package pl.kamilracki.flota.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Setter @Getter
@Table(name = User.TABLE)
public class User extends BaseEntity {
    public final static String TABLE = "users";

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "active")
    private Integer active;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @OneToOne
    private Car car;

    @OneToOne
    private FleetCard fleetCard;
}
