package com.prakarti.Blog.project.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateBlogRequest{


    @NotBlank(message = "userId is mandatory.")
    private String userId;
    @NotBlank(message = "Title is mandatory.")
    private String title;
    @NotBlank(message = "Description can't be blank.")
    private String description;
    @NotNull(message = "Publish cannot be blank.")
    private Boolean publish;

}
