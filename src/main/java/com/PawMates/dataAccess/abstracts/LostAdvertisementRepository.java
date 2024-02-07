package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.LostAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostAdvertisementRepository extends JpaRepository<LostAdvertisement, Long> {
}
