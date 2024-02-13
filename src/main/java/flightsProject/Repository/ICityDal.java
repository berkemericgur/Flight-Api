package flightsProject.Repository;

import flightsProject.Entitities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDal extends JpaRepository<City, Long> {
}
