package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.PetImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetImageRepository extends JpaRepository<PetImage, Long> {
}
