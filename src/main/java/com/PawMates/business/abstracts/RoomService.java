package com.PawMates.business.abstracts;

import com.PawMates.business.room.requests.CreateRoomRequest;
import com.PawMates.business.room.requests.UpdateRoomRequest;
import com.PawMates.business.room.responses.GetAllRoomsResponse;
import com.PawMates.business.room.responses.GetByIdRoomResponse;
import com.PawMates.entities.concretes.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(CreateRoomRequest request);
    void deleteRoom(Long id);
    Room updateRoom(UpdateRoomRequest request);
    List<GetAllRoomsResponse> getAllRooms();
    GetByIdRoomResponse getRoomById(Long id);
}
