package flightsProject.Entitities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Departure Airport")
    private String departureAirport;
    @Column(name = "Arrival Airport")
    private String arrivalAirport;
    @Column(name = "Departure Time")
    private String departureTime;
    @Column(name = "Return Time")
    private String returnTime;
    @Column(name = "Cost")
    private double cost;

}
