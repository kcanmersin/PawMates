package com.PawMates.business.abstracts;

import com.PawMates.business.advertisement.requests.CreateJobAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateJobAdvertisementRequest;
import com.PawMates.business.advertisement.responses.JobAdvertisementResponse;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisementResponse> getAll();
    JobAdvertisementResponse getById(Long id);
    void add(CreateJobAdvertisementRequest createJobAdvertisementRequest);
    void update(UpdateJobAdvertisementRequest updateJobAdvertisementRequest);
    void delete(Long id);
}
