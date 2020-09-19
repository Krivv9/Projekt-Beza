package pl.coderslab.superprojekt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class FleetCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cardNumber;

    @Column(nullable = false)
    private Integer phoneNumber;

    @Column(nullable = false)
    private Integer pinCard;

    @OneToOne
    private User user;

    @ManyToOne
    private Car car;
}
