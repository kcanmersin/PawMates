package com.PawMates.business.abstracts;

import java.util.List;

public interface AdvertisementService<T, R, C, U> {
    List<R> getAll();
    R getById(Long id);
    R add(C createRequest);
    R update(U updateRequest);
    void delete(Long id);
}
