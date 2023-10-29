package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "client_sequence")
    private Integer id;

    @Column(name = "client_name", length = 200)
    private String name;

}
