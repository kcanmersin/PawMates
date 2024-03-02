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
import com.PawMates.entities.concretes.Message;
import com.PawMates.entities.concretes.Pet;
import com.PawMates.entities.concretes.PetImage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetManager implements PetService {
    private  PetRepository petRepository;
    private PetBusinessRules petBusinessRules;
    private  ModelMapperService modelMapperService;
    private PetImageRepository petImageRepository;

//    @Override
//    public List<GetAllPetsResponse> getAll() {
//        List<Pet> pets = petRepository.findAll();
//        return pets.stream()
//                .map(pet -> modelMapperService.forResponse()
//                        .map(pet, GetAllPetsResponse.class))
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<GetAllPetsResponse> getAll() {
//        List<Pet> pets = petRepository.findAll();
//        return pets.stream().map(pet -> {
//            GetAllPetsResponse response = new GetAllPetsResponse();
//            response.setId(pet.getId());
//            response.setName(pet.getName());
//            response.setTypeId(pet.getType().getId());
//            response.setTypeName(pet.getType().getName()); // Assuming PetType has a name field
//            response.setBreed(pet.getBreed());
//            response.setAge(pet.getAge());
//            response.setGender(pet.getGender());
//            //response.setAdvertisementId(pet.getAdvertisement().getId()); // Assuming a direct relationship
//
//            // Assuming Pet has a collection of PetImage entities or similar
//            List<String> encodedImages = pet.getPetImages().stream()
//                    .map(petImage -> "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(petImage.getImage()))
//                    .collect(Collectors.toList());
//
//            response.setPetImages(encodedImages);
//            return response;
//        }).collect(Collectors.toList());
//    }
@Override
public List<GetAllPetsResponse> getAll() {
//    List<Pet> pets = petRepository.findAll();
//    return pets.stream().map(pet -> {
//        GetAllPetsResponse response = modelMapperService.forResponse().map(pet, GetAllPetsResponse.class);
//        //print response
//        // Pet'in resimlerini alıp, Base64'e çevir
//        List<String> encodedImages = new ArrayList<>();
//        pet.getPetImages().forEach(image -> {
//            String encodedImage = Base64.getEncoder().encodeToString(image.getImage()); // 'getData()' metodunuzun adı neyse
//            encodedImages.add(encodedImage);
//        });
//
//        response.setPetImages(encodedImages);
//        //print response
//        return response;
//    }).collect(Collectors.toList());
    return petRepository.findAll().stream().map(pet -> {
        GetAllPetsResponse response = modelMapperService.forResponse().map(pet, GetAllPetsResponse.class);
        // Pet'in resimlerini alıp, Base64'e çevir


        return response;
    }).collect(Collectors.toList());
   }

    @Override
    public GetByIdPetResponse getById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found!")); // RuntimeException yerine daha spesifik bir hata yönetimi yapısı kullanılabilir.
        return modelMapperService.forResponse().map(pet, GetByIdPetResponse.class);
    }

    @Override
    public void add(CreatePetRequest createPetRequest) {


        Pet pet = modelMapperService.forRequest().map(createPetRequest, Pet.class);
        petRepository.save(pet);
//        // Check if the pet name already exists
//        //petBusinessRules.checkIfPetNameExists(createPetRequest.getName());
//
//        // Check if the referenced pet type exists
//        petBusinessRules.checkIfPetTypeExists(createPetRequest.getTypeId());
//
//        // CreatePetRequest'ten Pet entity'sine dönüşüm
//        Pet pet = modelMapperService.forRequest().map(createPetRequest, Pet.class);
//
//        // Pet entity'sini kaydet
//        petRepository.save(pet);
//
//        // Eğer petImages null değilse ve uzunluğu 0'dan büyükse
//        if (createPetRequest.getPetImages() != null && createPetRequest.getPetImages().length > 0) {
//            // Her bir MultipartFile için döngü
//            for (MultipartFile file : createPetRequest.getPetImages()) {
//                // Dosyayı byte[] olarak al
//                byte[] imageBytes;
//                try {
//                    imageBytes = file.getBytes();
//                    // Yeni bir PetImage instance'ı oluştur
//                    PetImage petImage = new PetImage();
//                    petImage.setImage(imageBytes);
//                    petImage.setPet(pet); // PetImage'ı kaydedilen pet ile ilişkilendir
//                    // PetImage'ı kaydet
//                    petImageRepository.save(petImage);
//                } catch (IOException e) {
//                    // Resim yüklenirken bir hata oluştu
//                    e.printStackTrace();
//                    // Hata yönetimi için uygun bir işlem yapın
//                }
//            }
//        }
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
