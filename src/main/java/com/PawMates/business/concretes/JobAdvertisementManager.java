package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.JobAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateJobAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateJobAdvertisementRequest;
import com.PawMates.business.advertisement.responses.JobAdvertisementResponse;
import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.JobAdvertisementRepository;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.dataAccess.abstracts.PetTypeRepository;
import com.PawMates.entities.concretes.Address;
import com.PawMates.entities.concretes.Advertisement;
import com.PawMates.entities.concretes.JobAdvertisement;
import com.PawMates.entities.concretes.Pet;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;

    private final ModelMapperService modelMapperService;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

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
    @Transactional
    public void add(CreateJobAdvertisementRequest request) {
        // Create a new JobAdvertisement entity from the request
        JobAdvertisement advertisement = new JobAdvertisement();
        advertisement.setTitle(request.getTitle());
        advertisement.setContent(request.getContent());
        advertisement.setPhoneNumber(request.getPhoneNumber());
        advertisement.setEmail(request.getEmail());
        advertisement.setPosition(request.getPosition());
        advertisement.setSalary(request.getSalary());
        advertisement.setWorkingHours(request.getWorkingHours());

        // Set the Address if it's provided (assuming you have an Address entity and repository)
        if (request.getAddressId() != null) {
            Address address = new Address();
            address.setId(request.getAddressId());
            advertisement.setAddress(address);
        }

        // Save the JobAdvertisement entity to get the generated ID
        JobAdvertisement savedAdvertisement = jobAdvertisementRepository.save(advertisement);

        // Process and save Pets if they are provided in the request
        if (request.getPets() != null && !request.getPets().isEmpty()) {
            List<Pet> pets = request.getPets().stream().map(petRequest -> {
                Pet pet = new Pet();
                pet.setName(petRequest.getName());
                pet.setBreed(petRequest.getBreed());
                pet.setAge(petRequest.getAge());
                pet.setGender(petRequest.getGender());
                pet.setType(petTypeRepository.findById(petRequest.getTypeId())
                        .orElseThrow(() -> new RuntimeException("Pet type not found with id: " + petRequest.getTypeId())));
                pet.setAdvertisement(savedAdvertisement); // Link the Pet to the Advertisement
                return pet;
            }).collect(Collectors.toList());

            // Save all the Pet entities
            petRepository.saveAll(pets);
        }

        // If there are additional steps needed (such as sending notifications or updating other systems), add them here
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
