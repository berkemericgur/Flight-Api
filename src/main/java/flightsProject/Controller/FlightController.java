package flightsProject.Controller;

import flightsProject.Entitities.Flight;
import flightsProject.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> allFlights = flightService.findAllFlights();
        return new ResponseEntity<List<Flight>>(allFlights, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") long flightId) {
        Flight flightById = flightService.getFlightByID(flightId);
        if (flightById != null) {
            return new ResponseEntity<Flight>(flightById, HttpStatus.OK);
        } else {
            return null;
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Flight> addFlight(Flight flight) {
        Flight addFlight = flightService.addFlight(flight);
        return new ResponseEntity<Flight>(addFlight, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable("id") long flightId) {
        flightService.deleteFlightById(flightId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
