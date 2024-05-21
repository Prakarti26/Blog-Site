package com.prakarti.Blog.project.model;


import com.prakarti.Blog.project.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {

    private String name;
    private String userName;
    private String password;

    private Role role;
}
