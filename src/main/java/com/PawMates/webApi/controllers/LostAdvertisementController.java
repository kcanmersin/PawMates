package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.LostAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lostAdvertisements")
public class LostAdvertisementController {

    private final LostAdvertisementService lostAdvertisementService;

    @Autowired
    public LostAdvertisementController(LostAdvertisementService lostAdvertisementService) {
        this.lostAdvertisementService = lostAdvertisementService;
    }

    @GetMapping()
    public List<LostAdvertisementResponse> getAll() {
        return lostAdvertisementService.getAll();
    }

    @GetMapping("/{id}")
    public LostAdvertisementResponse getById(@PathVariable Long id) {
        return lostAdvertisementService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public LostAdvertisementResponse add(@RequestBody @Valid CreateLostAdvertisementRequest request) {
        return lostAdvertisementService.add(request);
    }

    @PutMapping("/{id}")
    public LostAdvertisementResponse update(@PathVariable Long id, @RequestBody @Valid UpdateLostAdvertisementRequest request) {
        request.setId(id); // Ensure the ID is set correctly
        return lostAdvertisementService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lostAdvertisementService.delete(id);
    }
}
