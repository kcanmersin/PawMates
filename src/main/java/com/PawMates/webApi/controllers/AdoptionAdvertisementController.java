package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.AdoptionAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdoptionAdvertisementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/adoptionAdvertisements")
public class AdoptionAdvertisementController {

    private final AdoptionAdvertisementService adoptionAdvertisementService;

    @Autowired
    public AdoptionAdvertisementController(AdoptionAdvertisementService adoptionAdvertisementService) {
        this.adoptionAdvertisementService = adoptionAdvertisementService;
    }

    @GetMapping()
    public List<AdoptionAdvertisementResponse> getAll() {
        return adoptionAdvertisementService.getAll();
    }

    @GetMapping("/{id}")
    public AdoptionAdvertisementResponse getById(@PathVariable Long id) {
        return adoptionAdvertisementService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AdoptionAdvertisementResponse add(@RequestBody @Valid CreateAdoptionAdvertisementRequest request) {
        return adoptionAdvertisementService.add(request);
    }

    @PutMapping("/{id}")
    public AdoptionAdvertisementResponse update( @RequestBody @Valid UpdateAdoptionAdvertisementRequest request) {

        return adoptionAdvertisementService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adoptionAdvertisementService.delete(id);
    }
}
