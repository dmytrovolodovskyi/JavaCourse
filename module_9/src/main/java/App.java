import data.Flat;
import data.Resident;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("osbb");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Resident> residentQuery = cb.createQuery(Resident.class);
        Root<Resident> residentRoot = residentQuery.from(Resident.class);
        residentRoot.fetch("flat").fetch("building");

        Join<Resident, Flat> flatJoin = residentRoot.join("flat");

        residentQuery.select(residentRoot);

        List<Resident> residents = em.createQuery(residentQuery).getResultList();

        for (Resident resident : residents) {
            System.out.println("Name: " + resident.getName());
            System.out.println("Email: " + resident.getEmail());
            System.out.println("Has Access: " + resident.isHasAccess());
            System.out.println("Flat Number: " + resident.getFlatId().getNumber());
            System.out.println("Floor: " + resident.getFlatId().getFloor());
            System.out.println("Address: " + resident.getFlatId().getBuilding().getAddress());
            System.out.println();
        }

        em.close();
        emf.close();
    }

}

