package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.JobAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateJobAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateJobAdvertisementRequest;
import com.PawMates.business.advertisement.responses.JobAdvertisementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
@RequiredArgsConstructor
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    @GetMapping()
    public List<JobAdvertisementResponse> getAll() {
        return jobAdvertisementService.getAll();
    }

    @GetMapping("/{id}")
    public JobAdvertisementResponse getById(@PathVariable Long id) {
        return jobAdvertisementService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateJobAdvertisementRequest request) {
        jobAdvertisementService.add(request);
}

@PutMapping()
public void update(@RequestBody @Valid UpdateJobAdvertisementRequest request) {
    jobAdvertisementService.update(request);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    jobAdvertisementService.delete(id);
}
}
