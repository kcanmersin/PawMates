package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.RoomService;
import com.PawMates.business.room.requests.CreateRoomRequest;
import com.PawMates.business.room.requests.UpdateRoomRequest;
import com.PawMates.business.room.responses.GetAllRoomsResponse;
import com.PawMates.business.room.responses.GetByIdRoomResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.RoomRepository;
import com.PawMates.entities.concretes.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomManager implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public Room createRoom(CreateRoomRequest request) {
        Room room = modelMapperService.forRequest().map(request, Room.class);
        // Additional business logic or validation can be added here
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room updateRoom(UpdateRoomRequest request) {
        Room room = modelMapperService.forRequest().map(request, Room.class);
        // Additional checks such as room existence or authorization could be implemented here
        return roomRepository.save(room);
    }

    @Override
    public List<GetAllRoomsResponse> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(room -> modelMapperService.forResponse().map(room, GetAllRoomsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdRoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found!"));
        return modelMapperService.forResponse().map(room, GetByIdRoomResponse.class);
    }
}
