package com.PawMates.business.abstracts;

import com.PawMates.business.address.requests.CreateAddressRequest;
import com.PawMates.business.address.requests.UpdateAddressRequest;
import com.PawMates.business.address.responses.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAll();
    AddressResponse getById(Long id);
    void add(CreateAddressRequest createAddressRequest);
    void update(UpdateAddressRequest updateAddressRequest);
    void delete(Long id);
}
