package com.prakarti.Blog.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogResponse {


    private String blogId;
    private String title;
    private String description;
    private Boolean publish;
    private String userId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
