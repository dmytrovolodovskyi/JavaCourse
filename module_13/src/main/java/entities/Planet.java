package entities;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "planet_name", length = 500)
    private String name;
}
