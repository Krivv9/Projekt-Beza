package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity @Setter @Getter
@Table(name = User.TABLE)
public class User extends BaseEntity {
    public final static String TABLE = "users";

    @Size(max = 20)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 20)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(min = 7, max = 9)
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "active")
    private int active;

    @Column(name = "password", nullable = false)
    private String password;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne
    private Car car;

    @OneToOne
    private FleetCard fleetCard;
}
