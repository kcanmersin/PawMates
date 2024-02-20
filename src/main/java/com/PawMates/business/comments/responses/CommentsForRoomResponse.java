package com.PawMates.business.comments.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsForRoomResponse {
    private Long id;
    private String content;
    private Long userId;
    private Date created;
    private List<CommentsForRoomResponse> replies;
}
