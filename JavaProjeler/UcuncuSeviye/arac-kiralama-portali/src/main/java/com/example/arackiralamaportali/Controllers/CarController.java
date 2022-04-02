package com.example.arackiralamaportali.Controllers;

import com.example.arackiralamaportali.Data.BrandRepository;
import com.example.arackiralamaportali.Data.CarRepository;
import com.example.arackiralamaportali.Data.CarTypeRepository;
import com.example.arackiralamaportali.Data.CompanyRepository;
import com.example.arackiralamaportali.Models.Brand;
import com.example.arackiralamaportali.Models.Car;
import com.example.arackiralamaportali.Models.CarType;
import com.example.arackiralamaportali.Models.Company;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final CompanyRepository companyRepository;
    private final CarTypeRepository carTypeRepository;

    public CarController(CarRepository carRepository, BrandRepository brandRepository, CompanyRepository companyRepository, CarTypeRepository carTypeRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.companyRepository = companyRepository;
        this.carTypeRepository = carTypeRepository;
    }


    @ModelAttribute("allCars")
    public List<Car> getAll(Model model){
        List<Car> cars = this.carRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));

        return cars;
    }

    @ModelAttribute("allBrands")
    public List<Brand> getBrands(Model model){
        return this.brandRepository.findAll();
    }

    @ModelAttribute("allCompanies")
    public List<Company> getCompanies(Model model){
        return this.companyRepository.findAll();
    }

    @ModelAttribute("allCarTypes")
    public List<CarType> getCarTypes(Model modek){ return this.carTypeRepository.findAll();}


    @GetMapping()
    public String showCars(Car car,Map<String,Object> map){
        ControllerTools.navbarAuth(map);
        return "car/car";
    }

    @PostMapping("/add")
    public String addCar(@Valid Car car, BindingResult result, Model model){
        if(result.hasErrors()){
            return "car/car";
        }
        car.setPlate(car.getPlate().toUpperCase());
        this.carRepository.save(car);
        return "redirect:/car";
    }


    @GetMapping("/{id}")
    public String getIdCar(@PathVariable("id") int id, Model model,Map<String,Object> map){
        Car car = this.carRepository.getById(id);
        model.addAttribute("car",car);
        ControllerTools.navbarAuth(map);
        return "car/car";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id, Model model){
        this.carRepository.deleteById(id);
        return "redirect:/car";
    }
}
