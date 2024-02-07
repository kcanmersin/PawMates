package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.AdoptionAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdoptionAdvertisementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoptionAdvertisements")
@RequiredArgsConstructor
public class AdoptionAdvertisementController {

    private final AdoptionAdvertisementService adoptionAdvertisementService;

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
    public void add(@RequestBody @Valid CreateAdoptionAdvertisementRequest request) {
        adoptionAdvertisementService.add(request);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateAdoptionAdvertisementRequest request) {
        adoptionAdvertisementService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adoptionAdvertisementService.delete(id);
    }
}
