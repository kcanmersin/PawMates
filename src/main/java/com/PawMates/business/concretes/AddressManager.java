package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.AddressService;
import com.PawMates.business.address.requests.CreateAddressRequest;
import com.PawMates.business.address.requests.UpdateAddressRequest;
import com.PawMates.business.address.responses.AddressResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.AddressRepository;
import com.PawMates.entities.concretes.Address;
import com.PawMates.entities.concretes.Pet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<AddressResponse> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapperService.forResponse().map(address, AddressResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse getById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found!"));
        return modelMapperService.forResponse().map(address, AddressResponse.class);
    }

    @Override
    public void add(CreateAddressRequest createAddressRequest) {
        Address address = modelMapperService.forRequest().map(createAddressRequest, Address.class);
        addressRepository.save(address);
    }

    @Override
    public void update(UpdateAddressRequest updateAddressRequest) {
        Address address  = modelMapperService.forRequest().map(updateAddressRequest, Address.class);
        addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
