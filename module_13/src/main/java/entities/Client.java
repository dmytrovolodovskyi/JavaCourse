package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_name", length = 200)
    private String name;

    @OneToMany(mappedBy = "clientId")
    private List<Ticket> tickets;
}
