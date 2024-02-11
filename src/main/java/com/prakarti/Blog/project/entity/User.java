package com.prakarti.Blog.project.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@Setter
@Document
public class User {
    @Id
    private String userId;
    private String fullName;
    private String userName;
    private String password;
    private byte role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
