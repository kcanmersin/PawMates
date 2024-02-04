package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    boolean existsByName(String name);
}