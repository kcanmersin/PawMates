package com.PawMates.authorization.repository;

import com.PawMates.authorization.models.ERole;
import com.PawMates.authorization.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
