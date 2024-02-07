package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.AdoptionAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionAdvertisementRepository extends JpaRepository<AdoptionAdvertisement, Long> {
}
