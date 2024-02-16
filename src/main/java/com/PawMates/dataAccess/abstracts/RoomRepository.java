package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository  extends JpaRepository<Room, Long> {
}
