package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.LostAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/lostAdvertisements")
@RequiredArgsConstructor
public class LostAdvertisementController {

    private final LostAdvertisementService lostAdvertisementService;

    @GetMapping()
    public List<LostAdvertisementResponse> getAll() {
        return lostAdvertisementService.getAll();
    }

    @GetMapping("/{id}")
    public LostAdvertisementResponse getById(@PathVariable Long id) {
        return lostAdvertisementService.getById(id);
    }

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLostAdvertisement(@RequestPart("lostAdvertisement") @Valid CreateLostAdvertisementRequest request,
                                     @RequestPart(value = "images", required = false) MultipartFile[] images) throws IOException {
        lostAdvertisementService.add(request, images);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateLostAdvertisementRequest request) {
        lostAdvertisementService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lostAdvertisementService.delete(id);
    }
}
