package com.PawMates.business.users.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByUsernameResponse {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
