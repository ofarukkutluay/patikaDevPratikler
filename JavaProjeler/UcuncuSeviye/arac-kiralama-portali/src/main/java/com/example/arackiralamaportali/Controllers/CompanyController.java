package com.example.arackiralamaportali.Controllers;

import com.example.arackiralamaportali.Data.CompanyRepository;
import com.example.arackiralamaportali.Models.Brand;
import com.example.arackiralamaportali.Models.Car;
import com.example.arackiralamaportali.Models.Company;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @ModelAttribute("allCompanies")
    public List<Company> getAll(Model model){
        List<Company> companies = this.companyRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));

        for(Company company : companies){
            for(var c : company.getCompanyCars()){
                System.out.println(c.getCar().getPlate());
            }
        }

        return companies;
    }


    @GetMapping()
    public String showCars(Company company){
        return "company/company";
    }

    @PostMapping("/add")
    public String addCompany(@Valid Company company, BindingResult result, Model model){
        if(result.hasErrors()){
            return "company/company";
        }

        this.companyRepository.save(company);
        return "redirect:/company";
    }


    @GetMapping("/{id}")
    public String getIdCompany(@PathVariable("id") int id, Model model){
        Company company = this.companyRepository.getById(id);
        model.addAttribute("company",company);
        return "company/company";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") int id, Model model){
        this.companyRepository.deleteById(id);
        return "redirect:/company";
    }

}
