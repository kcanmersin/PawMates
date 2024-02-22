package com.PawMates.business.abstracts;

import com.PawMates.business.users.requests.CreateUserRequest;
import com.PawMates.business.users.requests.UpdateUserRequest;
import com.PawMates.business.users.responses.GetUserByIdResponse;
import com.PawMates.business.users.responses.GetUserByUsernameResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    GetUserByIdResponse addUser(CreateUserRequest request);
    void deleteUser(Long id);
    void updateUser(UpdateUserRequest request);
    List<GetUserByIdResponse> getAllUsers();
    GetUserByIdResponse getUserById(Long id);
    GetUserByUsernameResponse getUserByUsername(String username);

    void updateProfilePicture(Long userId, MultipartFile profilePicture) throws Exception;
    void updateBackgroundPicture(Long userId, MultipartFile backgroundPicture) throws Exception;


}
