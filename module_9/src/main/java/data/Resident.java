package data;

import jakarta.persistence.*;

@Entity
@Table(name = "residents")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @Column(name = "has_access")
    private boolean hasAccess;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isHasAccess() {
        return hasAccess;
    }

    public Flat getFlatId() {
        return flat;
    }
}
