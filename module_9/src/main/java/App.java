import data.Resident;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("osbb");

        try (emf; EntityManager em = emf.createEntityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Resident> residentQuery = createResidentQuery(cb);
            List<Resident> residents = getResidents(em, residentQuery);

            printResidents(residents);

        }
    }

    private static CriteriaQuery<Resident> createResidentQuery(CriteriaBuilder cb) {
        CriteriaQuery<Resident> residentQuery = cb.createQuery(Resident.class);
        Root<Resident> residentRoot = residentQuery.from(Resident.class);
        residentRoot.fetch("flat").fetch("building");

        return residentQuery.select(residentRoot)
                .where(cb.equal(residentRoot.get("hasAccess"), false));
    }

    private static List<Resident> getResidents(EntityManager em, CriteriaQuery<Resident> residentQuery) {
        return em.createQuery(residentQuery)
                .getResultList();
    }

    private static void printResidents(List<Resident> residents) {
        for (Resident resident : residents) {
            System.out.println("Name: " + resident.getName());
            System.out.println("Email: " + resident.getEmail());
            System.out.println("Flat Number: " + resident.getFlatId().getNumber());
            System.out.println("Address: " + resident.getFlatId().getBuilding().getAddress());
            System.out.println();
        }
    }
}

