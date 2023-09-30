package data;

import jakarta.persistence.*;

@Entity
@Table(name = "flats")
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int floor;
    private int number;
    private float area;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Building getBuilding() {
        return building;
    }

    public long getId() {
        return id;
    }

    public int getAddress() {
        return floor;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumber() {
        return number;
    }

    public float getArea() {
        return area;
    }
}
