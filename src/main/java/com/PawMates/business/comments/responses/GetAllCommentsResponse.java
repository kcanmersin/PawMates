package com.PawMates.business.comments.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCommentsResponse {
    private Long id;
    private String content;
    private Long userId;
    private String username;
    private Long parentId; // Üst yorumun ID'si, üst yorum yoksa bu alan null olabilir.

    // Gerekiyorsa diğer alanlar...
}
