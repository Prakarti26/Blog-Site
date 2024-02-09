package com.prakarti.Blog.project.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBlogRequest {
    @NotBlank(message = "blogId is required parameter.")
    private String blogId;
    @NotBlank(message = "Title is required parameter.")
    private String title;
    @NotBlank(message = "Description is required parameter.")
    private String description;

    @NotNull(message = "Publish is required parameter.")
    private Boolean publish;
    @NotBlank(message = "UserId is required parameter.")
    private String userId;

}

