package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    // Custom query methods if necessary
}
