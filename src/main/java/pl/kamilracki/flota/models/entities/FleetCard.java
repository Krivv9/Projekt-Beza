package pl.kamilracki.flota.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = FleetCard.TABLE)
public class FleetCard extends BaseEntity {
    public final static String TABLE = "fleet_cards";

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "pin_card", nullable = false)
    private String pinCard;

    @OneToOne
    private User user;

    @ManyToOne
    private Car car;
}
