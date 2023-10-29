import crud.ClientCrudService;
import crud.PlanetCrudService;
import entities.Client;
import entities.Planet;
import utils.FlywayMigration;


public class App {
    public static void main(String[] args) {

        FlywayMigration.migrateDb();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Client newClient = new Client();
        newClient.setName("New Client");
        clientCrudService.persist(newClient);

        Client firstClient = clientCrudService.getById(1L);
        firstClient.setName("Updated Client");
        clientCrudService.merge(firstClient);

        clientCrudService.remove(newClient);


        Planet newPlanet = new Planet();
        newPlanet.setId("MER");
        newPlanet.setName("Mercury");
        planetCrudService.persist(newPlanet);

        Planet mercury = planetCrudService.getById("MER");
        mercury.setId("NEP");
        mercury.setName("Neptune");
        planetCrudService.merge(mercury);

        planetCrudService.remove(newPlanet);

    }
}
