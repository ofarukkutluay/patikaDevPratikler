package com.example.arackiralamaportali.Controllers;

import com.example.arackiralamaportali.Data.*;
import com.example.arackiralamaportali.Models.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.Period;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rent")
public class RentController {
    private final CityRepository cityRepository;
    private final CarRepository carRepository;
    private final CarTypeRepository carTypeRepository;
    private final UserRepository userRepository;
    private final RentRepository rentRepository;
    private Car findCar;

    public RentController(CityRepository cityRepository, CarRepository carRepository, CarTypeRepository carTypeRepository, UserRepository userRepository, RentRepository rentRepository) {
        this.cityRepository = cityRepository;
        this.carRepository = carRepository;
        this.carTypeRepository = carTypeRepository;
        this.userRepository = userRepository;
        this.rentRepository = rentRepository;
    }

    @ModelAttribute("allCities")
    public List<City> allCities(){
        List<City> cities = this.cityRepository.findAll();
        return cities;
    }

    @ModelAttribute("allCarTypes")
    public List<CarType> getCarTypes(){ return this.carTypeRepository.findAll();}

    @GetMapping()
    public String rent(RentFilterVM rentFilterVM,Map<String, Object> map){
        ControllerTools.navbarAuth(map);
        if (rentFilterVM != null){
            List<Car> filterCars = this.carRepository.findByType_IdAndCompany_City_Id(rentFilterVM.getTypeId(), rentFilterVM.getCityId());
            map.put("filterCars",filterCars);
        }
        map.put("rentFilter",new RentFilterVM());
        return "rent/rent";
    }

    @GetMapping("/{carId}")
    public String rentCar(@PathVariable("carId") int carId,Map<String,Object> map){
        ControllerTools.navbarAuth(map);
        this.findCar = this.carRepository.getById(carId);
        map.put("car",findCar);
        map.put("rent",new Rent());

        return "rent/rent-car";
    }

    @PostMapping("/add")
    public String rentAdd(Rent rent,Map<String,Object> map){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User findUser = this.userRepository.findByUserName(auth.getName());
        rent.setCar(this.findCar);
        rent.setUser(findUser);

        Period diff = Period.between(rent.getStartRent(),rent.getEndRent());

        double totalPrice = diff.getDays() * this.findCar.getDailyPrice();
        rent.setTotalPrice(totalPrice);
        rent.setReservation(true);

        this.rentRepository.save(rent);
        return "redirect:/rent";
    }

}
