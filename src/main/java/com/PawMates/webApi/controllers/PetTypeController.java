package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.PetTypeService;
import com.PawMates.business.pet.requests.CreatePetTypeRequest;
import com.PawMates.business.pet.responses.GetByIdPetResponse;
import com.PawMates.business.petType.requests.UpdatePetTypeRequest;
import com.PawMates.business.petType.responses.GetAllPetTypesResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petTypes")
@RequiredArgsConstructor
public class PetTypeController {

    private final PetTypeService petTypeService;

    @GetMapping
    public List<GetAllPetTypesResponse> getAll() {
        return petTypeService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdPetResponse getById(@PathVariable Long id) {
        return petTypeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreatePetTypeRequest request) {
        petTypeService.add(request);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdatePetTypeRequest updatePetTypeRequest) {

        petTypeService.update(updatePetTypeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        petTypeService.delete(id);
    }
}
