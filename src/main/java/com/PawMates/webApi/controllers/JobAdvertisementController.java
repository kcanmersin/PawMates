package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.JobAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateJobAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateJobAdvertisementRequest;
import com.PawMates.business.advertisement.responses.JobAdvertisementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

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
    public JobAdvertisementResponse add(@RequestBody @Valid CreateJobAdvertisementRequest request) {
        return jobAdvertisementService.add(request);
    }

    @PutMapping("/{id}")
    public JobAdvertisementResponse update(@PathVariable Long id, @RequestBody @Valid UpdateJobAdvertisementRequest request) {
        request.setId(id); // Ensure the ID is set correctly
        return jobAdvertisementService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
