package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
