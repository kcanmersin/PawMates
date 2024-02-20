package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.RoomService;
import com.PawMates.business.comments.responses.CommentsForRoomResponse;
import com.PawMates.business.room.requests.CreateRoomRequest;
import com.PawMates.business.room.requests.UpdateRoomRequest;
import com.PawMates.business.room.responses.GetAllRoomsResponse;
import com.PawMates.business.room.responses.GetByIdRoomResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping()
    public List<GetAllRoomsResponse> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public GetByIdRoomResponse getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoom(@RequestBody @Valid CreateRoomRequest createRoomRequest) {
        roomService.createRoom(createRoomRequest);
    }

    @PutMapping("/{id}")
    public void updateRoom(@PathVariable Long id, @RequestBody @Valid UpdateRoomRequest updateRoomRequest) {
        // Ensure the ID is consistent across the path variable and request body
        if (!id.equals(updateRoomRequest.getId())) {
            throw new IllegalArgumentException("ID in the path and request body must match");
        }
        roomService.updateRoom(updateRoomRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
    @GetMapping("/{roomId}/comments")
    public List<CommentsForRoomResponse> getCommentsForRoom(@PathVariable Long roomId) {
        return roomService.getCommentsForRoom(roomId);
    }
}
