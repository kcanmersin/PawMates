package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.JobAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateJobAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateJobAdvertisementRequest;
import com.PawMates.business.advertisement.responses.JobAdvertisementResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.JobAdvertisementRepository;
import com.PawMates.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<JobAdvertisementResponse> getAll() {
        List<JobAdvertisement> advertisements = jobAdvertisementRepository.findAll();
        return advertisements.stream()
                .map(advertisement -> modelMapperService.forResponse().map(advertisement, JobAdvertisementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobAdvertisementResponse getById(Long id) {
        JobAdvertisement advertisement = jobAdvertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job advertisement not found!"));
        return modelMapperService.forResponse().map(advertisement, JobAdvertisementResponse.class);
    }

    @Override
    public void add(CreateJobAdvertisementRequest request) {
        JobAdvertisement advertisement = modelMapperService.forRequest().map(request, JobAdvertisement.class);
        jobAdvertisementRepository.save(advertisement);
    }

    @Override
    public void update(UpdateJobAdvertisementRequest request) {
        JobAdvertisement advertisement = modelMapperService.forRequest().map(request, JobAdvertisement.class);
        jobAdvertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        jobAdvertisementRepository.deleteById(id);
    }
}
