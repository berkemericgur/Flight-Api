package flightsProject.Services;

import flightsProject.Entitities.Flight;
import flightsProject.FlightsProjectApplication;
import flightsProject.Repository.IFlightDal;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FlightService {

    private IFlightDal flightDal;
    private final String baseUrl = "https://localhost:8080/flight/api/flights";

    @Scheduled(cron = " 0 0 * * * *")
    public void saveFlightData() {
        RestTemplate restTemplate = new RestTemplate(); //An HTTP Cliend application from Spring
        FlightsProjectApplication response = restTemplate.getForObject(
                baseUrl, FlightsProjectApplication.class);
    }

    public Flight findFlightByOneWayCriteria(String departureAirport, String arrivalAirport, String departureTime) {
        List<Flight> allFlights = findAllFlights();

        for (Flight flight : allFlights) {
            if (Objects.equals(flight.getDepartureAirport(), departureAirport) &&
                    Objects.equals(flight.getArrivalAirport(), arrivalAirport) &&
                    Objects.equals(flight.getDepartureTime(), departureTime)){
                double newCost = flight.getCost() / 2;
                flight.setCost(newCost);
                return flight;
            }
        }
        return null;
    }

    public Flight findFlightByCriteria(String departureAirport, String arrivalAirport, String departureTime, String returnTime) {
        List<Flight> allFlights = findAllFlights();

        for (Flight flight : allFlights) {
            if (Objects.equals(flight.getDepartureAirport(), departureAirport) &&
                    Objects.equals(flight.getArrivalAirport(), arrivalAirport) &&
                    Objects.equals(flight.getDepartureTime(), departureTime) &&
                    Objects.equals(flight.getReturnTime(), returnTime)) {
                return flight;
            }
        }
        return null;
    }

    public Flight addFlight(Flight flight) {
        return flightDal.save(flight);
    }

    public List<Flight> findAllFlights() {
        return flightDal.findAll();
    }

    public Flight getFlightByID(long flightId) {
        return flightDal.findById(flightId).orElse(null);
    }

    public void deleteFlightById(long flightId) {
        flightDal.deleteById(flightId);
    }


}
