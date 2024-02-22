package com.PawMates.business.address.requests;

import com.PawMates.entities.concretes.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "District cannot be blank")
    private String district;

    @NotBlank(message = "Neighborhood cannot be blank")
    private String neighborhood;

    @NotBlank(message = "Street cannot be blank")
    private String street;

    private String street2; // Optional, no validation

    @NotBlank(message = "Building number cannot be blank")
    private String buildingNumber;

    private String floor; // Optional, no validation

    private String apartmentNumber; // Optional, no validation

    private String additionalInfo; // Optional, no validation

    @NotBlank(message = "Zip code cannot be blank")
    @Size(min = 5, max = 10, message = "Zip code must be between 5 and 10 characters")
    private String zipCode;

    private Location location; // Optional, no validation
}
