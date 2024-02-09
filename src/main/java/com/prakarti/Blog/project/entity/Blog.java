package com.prakarti.Blog.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@Setter
@Document
public class Blog {

    @Id
    private String blogId;
    private String title;
    private String description;
    private Boolean publish;
    private String userId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
