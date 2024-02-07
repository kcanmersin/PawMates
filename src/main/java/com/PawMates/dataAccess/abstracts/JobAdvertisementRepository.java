package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {
}
