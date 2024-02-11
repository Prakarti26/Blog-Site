package com.prakarti.Blog.project.model;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Getter
@Setter
public class CreateCommentRequest {


    @NotBlank(message = "userId cannot be blank")
    private String userId;
    @NotBlank(message = "blogId cannot be blank")
    private String blogId;
    @NotBlank(message = "comment cannot be blank")
    private String comment;
}
