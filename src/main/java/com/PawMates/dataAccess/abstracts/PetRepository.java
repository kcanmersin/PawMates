package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    boolean existsByName(String name);//concrete olmamasına rağmen jpa bunu handlelıyor
    // Buraya özel sorgularınızı ekleyebilirsiniz.
}
