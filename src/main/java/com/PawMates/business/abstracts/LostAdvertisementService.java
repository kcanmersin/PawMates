package com.PawMates.business.abstracts;

import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LostAdvertisementService {
    List<LostAdvertisementResponse> getAll();
    LostAdvertisementResponse getById(Long id);
    void add(CreateLostAdvertisementRequest createLostAdvertisementRequest, MultipartFile[] images) throws IOException;
    void update(UpdateLostAdvertisementRequest updateLostAdvertisementRequest);
    void delete(Long id);
}
