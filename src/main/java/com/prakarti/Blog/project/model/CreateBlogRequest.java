package com.prakarti.Blog.project.model;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateBlogRequest{


    private String blogId;
    private String title;
    private String description;
    private Boolean publish;
    private String  userId;

}
