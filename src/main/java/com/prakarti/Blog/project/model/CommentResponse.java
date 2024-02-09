package com.prakarti.Blog.project.model;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor

public class CommentResponse {


    private String commentId;
    private String title;
    private String blogId;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
