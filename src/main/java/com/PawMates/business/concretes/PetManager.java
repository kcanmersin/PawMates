package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.PetService;
import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.business.pet.requests.UpdatePetRequest;
import com.PawMates.business.pet.responses.GetAllPetsResponse;
import com.PawMates.business.pet.responses.GetByIdPetResponse;
import com.PawMates.business.rules.PetBusinessRules;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.PetImageRepository;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.entities.concretes.Pet;
import com.PawMates.entities.concretes.PetImage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetManager implements PetService {
    private  PetRepository petRepository;
    private PetBusinessRules petBusinessRules;
    private  ModelMapperService modelMapperService;
    private PetImageRepository petImageRepository;

    @Override
    public List<GetAllPetsResponse> getAll() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream()
                .map(pet -> modelMapperService.forResponse()
                        .map(pet, GetAllPetsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdPetResponse getById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found!")); // RuntimeException yerine daha spesifik bir hata yönetimi yapısı kullanılabilir.
        return modelMapperService.forResponse().map(pet, GetByIdPetResponse.class);
    }

    @Override
    public void add(CreatePetRequest createPetRequest) {
        // Check if the pet name already exists
        //petBusinessRules.checkIfPetNameExists(createPetRequest.getName());

        // Check if the referenced pet type exists
        petBusinessRules.checkIfPetTypeExists(createPetRequest.getTypeId());

        // CreatePetRequest'ten Pet entity'sine dönüşüm
        Pet pet = modelMapperService.forRequest().map(createPetRequest, Pet.class);

        // Pet entity'sini kaydet
        Pet savedPet = petRepository.save(pet);

        // Eğer petImages null değilse ve uzunluğu 0'dan büyükse
        if (createPetRequest.getPetImages() != null && createPetRequest.getPetImages().length > 0) {
            // Her bir MultipartFile için döngü
            for (MultipartFile file : createPetRequest.getPetImages()) {
                // Dosyayı byte[] olarak al
                byte[] imageBytes;
                try {
                    imageBytes = file.getBytes();
                    // Yeni bir PetImage instance'ı oluştur
                    PetImage petImage = new PetImage();
                    petImage.setImage(imageBytes);
                    petImage.setPet(savedPet); // PetImage'ı kaydedilen pet ile ilişkilendir
                    // PetImage'ı kaydet
                    petImageRepository.save(petImage);
                } catch (IOException e) {
                    // Resim yüklenirken bir hata oluştu
                    e.printStackTrace();
                    // Hata yönetimi için uygun bir işlem yapın
                }
            }
        }
    }


    @Override
    public void update(UpdatePetRequest updatePetRequest) {
        Pet pet = modelMapperService.forRequest().map(updatePetRequest, Pet.class);
        petRepository.save(pet); // Mevcut pet'in üzerine yazılması gerekiyor, bu yüzden güncellenmeden önce varlığın kontrolü yapılabilir.
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }
}
