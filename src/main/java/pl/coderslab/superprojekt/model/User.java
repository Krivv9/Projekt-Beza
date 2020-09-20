package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Setter @Getter
@Table(name = User.TABLE)
public class User {
    public final static String TABLE = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String password;

    @OneToOne
    private Car car;


}
