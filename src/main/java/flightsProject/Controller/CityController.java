package flightsProject.Controller;

import flightsProject.Entitities.City;
import flightsProject.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/getAll")
    public ResponseEntity<List<City>> getAllCities(City city) {
        List<City> allCities = cityService.findAllCities();
        return new ResponseEntity<List<City>>(allCities, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") long cityId) {
        City getById = cityService.getCityById(cityId);
        if (getById != null) {
            return new ResponseEntity<City>(getById, HttpStatus.OK);
        } else {
            return new ResponseEntity<City>(getById, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City addCity = cityService.addCity(city);
        return new ResponseEntity<City>(addCity, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable("id") Long id) {
        cityService.deleteCityById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
