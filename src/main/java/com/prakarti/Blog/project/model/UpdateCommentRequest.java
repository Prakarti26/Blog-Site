package com.prakarti.Blog.project.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor


public class UpdateCommentRequest {

    @NotBlank(message = "commentId is required parameter.")
    private String commentId;
    @NotBlank(message = "Title is required parameter.")
    private String title;
    @NotBlank(message = "blogId is required parameter.")
    private String blogId;
    @NotBlank(message = "userId is required parameter.")
    private String userId;
}
