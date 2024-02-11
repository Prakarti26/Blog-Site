package com.prakarti.Blog.project.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Blog {
    @Id
    private String blogId;
    private String userId;
    private String title;
    private String description;
    private Boolean publish;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String   toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publish=" + publish +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
