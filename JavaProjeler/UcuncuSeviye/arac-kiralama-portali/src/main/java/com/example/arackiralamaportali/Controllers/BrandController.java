package com.example.arackiralamaportali.Controllers;

import com.example.arackiralamaportali.Data.BrandRepository;
import com.example.arackiralamaportali.Models.Brand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @ModelAttribute("allBrands")
    public List<Brand> getAll(Model model){
        return this.brandRepository.findAll();
    }

    @GetMapping()
    public String showBrand(Brand brand){
        return "brand/brand";
    }

    @PostMapping("/add")
    public String addBrand(@Valid Brand brand, BindingResult result, Model model){
        if (result.hasErrors()){
            return "brand/brand";
        }
        this.brandRepository.save(brand);
        return "redirect:/brand";
    }

    @GetMapping("/{id}")
    public String getIdBrand(@PathVariable("id") int id, Model model){
        Brand brand = this.brandRepository.getById(id);
        model.addAttribute("brand",brand);
        return "brand/brand";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") int id, Model model){
        this.brandRepository.deleteById(id);
        return "redirect:/brand";
    }
}
