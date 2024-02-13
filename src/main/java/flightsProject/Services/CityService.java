package flightsProject.Services;

import flightsProject.Entitities.City;
import flightsProject.Repository.ICityDal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private ICityDal cityDal;

    public City addCity(City city){
        return cityDal.save(city);
    }
    public List<City> findAllCities(){
        return cityDal.findAll();
    }
    public City getCityById(long cityId){
        return cityDal.findById(cityId).get();
    }
    public void deleteCityById(long cityId){
        cityDal.deleteById(cityId);
    }
}
