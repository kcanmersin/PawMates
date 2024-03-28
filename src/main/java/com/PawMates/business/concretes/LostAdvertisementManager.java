package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.LostAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;
import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.LostAdvertisementRepository;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.entities.concretes.Image;
import com.PawMates.entities.concretes.LostAdvertisement;
import com.PawMates.entities.concretes.Pet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LostAdvertisementManager implements LostAdvertisementService {
    private final LostAdvertisementRepository lostAdvertisementRepository;
    private final ModelMapperService modelMapperService;
    private final PetRepository petRepository;
    @Override
    public List<LostAdvertisementResponse> getAll() {
        List<LostAdvertisement> advertisements = lostAdvertisementRepository.findAll();
        return advertisements.stream()
                .map(advertisement -> modelMapperService.forResponse().map(advertisement, LostAdvertisementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public LostAdvertisementResponse getById(Long id) {
        LostAdvertisement advertisement = lostAdvertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lost advertisement not found!"));
        return modelMapperService.forResponse().map(advertisement, LostAdvertisementResponse.class);
    }

    @Override
    public void add(CreateLostAdvertisementRequest request, MultipartFile[] images) throws IOException {
        // Map the request to a LostAdvertisement entity
        LostAdvertisement advertisement = modelMapperService.forRequest().map(request, LostAdvertisement.class);
        // Initialize the pets list for the advertisement to ensure it's not null
        advertisement.setPets(new ArrayList<>());

        // Process pets from the request
        if (request.getPets() != null && !request.getPets().isEmpty()) {
            for (CreatePetRequest petRequest : request.getPets()) {
                // Map each CreatePetRequest to a Pet entity
                Pet pet = modelMapperService.forRequest().map(petRequest, Pet.class);
                pet.setAdvertisement(advertisement); // Associate the pet with the advertisement
                advertisement.getPets().add(pet); // Add the pet to the advertisement's list of pets
            }
        }

        // Assuming images are to be associated with the advertisement directly
        if (images != null && images.length > 0) {
            List<Image> advertisementImages = new ArrayList<>();
            for (MultipartFile file : images) {
                // Here you should implement the logic to store the images and create Image entities
                // For example, you might store the images on disk or in a blob store, and save their paths in the database
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setData(file.getBytes()); // Store the image bytes; consider storing just a reference/path instead
                image.setAdvertisement(advertisement); // Associate the image with the advertisement
                advertisementImages.add(image);
            }
            advertisement.setImages(advertisementImages); // Set the images for the advertisement
        }

        // Save the advertisement, which now includes pets and images
        lostAdvertisementRepository.save(advertisement);
    }




    @Override
    public void update(UpdateLostAdvertisementRequest request) {
        LostAdvertisement advertisement = modelMapperService.forRequest().map(request, LostAdvertisement.class);
        lostAdvertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        lostAdvertisementRepository.deleteById(id);
    }
}
