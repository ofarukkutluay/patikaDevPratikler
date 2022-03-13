package com.example.arackiralamaportali.Controllers;

import com.example.arackiralamaportali.Data.BrandRepository;
import com.example.arackiralamaportali.Data.CarRepository;
import com.example.arackiralamaportali.Models.Brand;
import com.example.arackiralamaportali.Models.Car;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;

    public CarController(CarRepository carRepository, BrandRepository brandRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
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

    @GetMapping()
    public String showCars(Car car){
        return "car/car";
    }

    @PostMapping("/add-car")
    public String addCar(@Valid Car car, BindingResult result, Model model){
        if(result.hasErrors()){
            return "car/car";
        }

        this.carRepository.save(car);
        return "redirect:/car";
    }


    @GetMapping("/{id}")
    public String getIdCar(@PathVariable("id") int id, Model model){
        Car car = this.carRepository.getById(id);
        model.addAttribute("car",car);
        return "car/car";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id, Model model){
        this.carRepository.deleteById(id);
        return "redirect:/car";
    }
}
