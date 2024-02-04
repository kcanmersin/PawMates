package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.AddressService;
import com.PawMates.business.address.requests.CreateAddressRequest;
import com.PawMates.business.address.requests.UpdateAddressRequest;
import com.PawMates.business.address.responses.AddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping()
    public List<AddressResponse> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressResponse getById(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateAddressRequest createAddressRequest) {
        addressService.add(createAddressRequest);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest) {

        addressService.update(updateAddressRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
