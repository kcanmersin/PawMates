package com.PawMates.business.address.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Long id;
    private String country;
    private String city;
    private String district;
    private String neighborhood;
    private String street;
    private String street2;
    private String buildingNumber;
    private String floor;
    private String apartmentNumber;
    private String additionalInfo;
    private String zipCode;
    private String state;
    private Double latitude;
    private Double longitude;
}
