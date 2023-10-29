import crud.ClientCrudService;
import crud.PlanetCrudService;
import crud.TicketCrudService;
import entities.Client;
import entities.Planet;
import entities.Ticket;


public class App {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        Client newClient = new Client();
        newClient.setId(1L);
        newClient.setName("Client");
        clientCrudService.merge(newClient);

        Planet toPlanet = new Planet();
        toPlanet.setId("SAT");
        toPlanet.setName("Saturn");
        planetCrudService.merge(toPlanet);

        Planet fromPlanet = new Planet();
        fromPlanet.setId("EA");
        fromPlanet.setName("Earth");
        planetCrudService.merge(fromPlanet);

        Ticket newTicket = new Ticket();
        newTicket.setId(1L);
        newTicket.setCreatedAt("21:00");
        newTicket.setClientId(newClient);
        newTicket.setToPlanetId(toPlanet);
        newTicket.setFromPlanetId(fromPlanet);
        ticketCrudService.merge(newTicket);

    }
}
