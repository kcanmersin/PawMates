package com.PawMates.business.advertisement.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateAdvertisementRequest extends CreateAdvertisementRequest {
    private Long id; // Güncellenecek ilanın ID'si
}
