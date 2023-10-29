package entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanetId;

    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanetId;

}
