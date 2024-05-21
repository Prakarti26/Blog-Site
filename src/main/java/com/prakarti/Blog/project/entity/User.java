package com.prakarti.Blog.project.entity;

import com.prakarti.Blog.project.entity.enums.Role;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    @Id
    private String userId;
    private String name;
    private String username;
    private String password;
    private Role role;
    private Integer isSocialRegister;
    private Integer otp;
    private Integer isAccountVerify;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
