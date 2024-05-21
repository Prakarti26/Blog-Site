package com.prakarti.Blog.project.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBlogRequest {
    @NotBlank(message = "Blog Id cannot be blank")
    private String blogId;
    @NotBlank(message = "User Id cannot be blank")
    private String userId;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotNull(message = "Publish cannot be blank")
    private Boolean publish;
}
