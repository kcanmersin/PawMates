package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // Custom query methods if necessary
}
