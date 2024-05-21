package com.prakarti.Blog.project.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
public class LoginUserRequest {

    @NotBlank(message = "UserName cannot be blank")
    private String userName;
    @NotBlank(message = "Password cannot be blank")
    private String password;

//    when we login using any social media example gmail,facebook etc..
    private int isSocialRegister;

    @Override
    public String toString(){
        return "LoginUserRequest{" +
                "username='" + userName + '\'' +
                ",isSocialRegister=" + isSocialRegister +
                '}';
    }
}
