package flightsProject.Repository;

import flightsProject.Entitities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightDal extends JpaRepository<Flight, Long> {
}
