package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.AdvertisementService;
import com.PawMates.business.advertisement.requests.CreateAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdvertisementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping()
    public List<AdvertisementResponse> getAll() {
        return advertisementService.getAll();
    }

    @GetMapping("/{id}")
    public AdvertisementResponse getById(@PathVariable Long id) {
        return advertisementService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateAdvertisementRequest createAdvertisementRequest) {
        advertisementService.add(createAdvertisementRequest);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateAdvertisementRequest updateAdvertisementRequest) {
        advertisementService.update(updateAdvertisementRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        advertisementService.delete(id);
    }
}
