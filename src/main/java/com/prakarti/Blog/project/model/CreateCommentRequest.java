package com.prakarti.Blog.project.model;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Getter
@Setter
public class CreateCommentRequest {


    private String commentId;
    private String title;
    private String blogId;
    private String userId;
}
