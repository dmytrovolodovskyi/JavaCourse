package entities;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "planet_name", length = 500)
    private String name;

    @OneToMany(mappedBy = "toPlanetId", fetch = FetchType.EAGER)
    private List<Ticket> toPlanetsTickets;

    @OneToMany(mappedBy = "fromPlanetId", fetch = FetchType.EAGER)
    private List<Ticket> fromPlanetsTickets;

}
