package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.PetService;
import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.business.pet.requests.UpdatePetRequest;
import com.PawMates.business.pet.responses.GetAllPetsResponse;
import com.PawMates.business.pet.responses.GetByIdPetResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping()
    public List<GetAllPetsResponse> getAll() {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdPetResponse getById(@PathVariable Long id) {
        return petService.getById(id);
    }

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@ModelAttribute @Valid CreatePetRequest createPetRequest) {
        petService.add(createPetRequest);
    }


    @PutMapping()
    public void update( @RequestBody @Valid UpdatePetRequest updatePetRequest) {
        // Ensure the ID is consistent across the path variable and request body
//        if (!id.equals(updatePetRequest.getId())) {
//            throw new IllegalArgumentException("ID in the path and request body must match");
//        }
        petService.update(updatePetRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        petService.delete(id);
    }
}
