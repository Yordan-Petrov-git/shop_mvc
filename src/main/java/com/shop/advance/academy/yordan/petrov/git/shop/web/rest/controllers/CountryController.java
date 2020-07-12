package com.shop.advance.academy.yordan.petrov.git.shop.web.rest.controllers;

import com.shop.advance.academy.yordan.petrov.git.shop.domain.models.CountryServiceModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.models.CountryServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/country")
@Slf4j
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CountryServiceViewModel> createCountry(@RequestBody CountryServiceModel countryServiceModel) {
        CountryServiceViewModel countryServiceViewModel = countryService.createCountry(countryServiceModel);
        log.info("Country  created : {}", countryServiceViewModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryServiceViewModel);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CountryServiceViewModel> updateCountry(@PathVariable("id") Long id, @RequestBody CountryServiceModel countryServiceModel) {
        CountryServiceViewModel countryServiceViewModel = countryService.updateCountry(countryServiceModel);
        log.info("Country  Updated : {}", countryServiceViewModel);
        return ResponseEntity.status(HttpStatus.OK).body(countryServiceViewModel);
    }


    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CountryServiceViewModel> getCountry(@PathVariable("id") final Long id) {
        CountryServiceViewModel countryServiceViewModel = countryService.getCountryById(id);
        log.info("Country  found : {}", countryServiceViewModel);
        return ResponseEntity.status(HttpStatus.FOUND).body(countryServiceViewModel);
    }

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<CountryServiceViewModel>> getCountries() {
        List<CountryServiceViewModel> countryServiceViewModels = countryService.getAllCountries();
        log.info("Country Found: {} ", countryServiceViewModels);
        return ResponseEntity.status(HttpStatus.FOUND).body(countryServiceViewModels);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CountryServiceViewModel> deleteCountry(@PathVariable("id") Long id) {
        CountryServiceViewModel countryServiceViewModel = countryService.deleteCountryById(id);
        log.info("Country  deleted : {}", countryServiceViewModel);
        return ResponseEntity.status(HttpStatus.OK).body(countryServiceViewModel);
    }

}
