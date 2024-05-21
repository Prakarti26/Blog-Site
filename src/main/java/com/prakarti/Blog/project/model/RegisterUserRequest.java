package com.prakarti.Blog.project.model;


import com.prakarti.Blog.project.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
public class RegisterUserRequest {

    @NotBlank(message = "Fullname cannot be blank")
    private String name;

    @Email(message = "UserName cannot be blank")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Role cannot be blank")
    private Role role;

    @Override
    public String toString() {
        return "RegisterUserRequest{" +
                "fullName='" + name + '\'' +
                ", username='" + userName + '\'' +
                ", role=" + role +
                '}';
    }

}
