package com.example.arackiralamaportali.Controllers;


import com.example.arackiralamaportali.Data.CarRepository;
import com.example.arackiralamaportali.Data.CityRepository;
import com.example.arackiralamaportali.Data.CompanyRepository;
import com.example.arackiralamaportali.Models.City;
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
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final CityRepository cityRepository;

    public CompanyController(CompanyRepository companyRepository, CityRepository cityRepository) {
        this.companyRepository = companyRepository;
        this.cityRepository = cityRepository;
    }

    @ModelAttribute("allCompanies")
    public List<Company> getAll(Model model){
        List<Company> companies = this.companyRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        return companies;
    }

    @ModelAttribute("allCities")
    public List<City> getCities(){
        List<City> cities = this.cityRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        return cities;
    }

    @GetMapping()
    public String showCompanies(Company company, Map<String,Object> map){
        ControllerTools.navbarAuth(map);
        return "company/company";
    }

    @PostMapping("/add")
    public String addCompany(@Valid Company company,BindingResult result, Model model){
        if(result.hasErrors()){
            return "company/company";
        }
        this.companyRepository.save(company);
        return "redirect:/company";
    }

    @GetMapping("/{id}")
    public String getIdCompany(@PathVariable("id") int id, Model model,Map<String,Object> map){
        Company company = this.companyRepository.getById(id);

        model.addAttribute("company",company);
        ControllerTools.navbarAuth(map);
        return "company/company";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") int id, Model model){
        this.companyRepository.deleteById(id);
        return "redirect:/company";
    }

}
