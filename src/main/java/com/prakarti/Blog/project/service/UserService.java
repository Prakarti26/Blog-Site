package com.prakarti.Blog.project.service;


import com.prakarti.Blog.project.entity.User;
import com.prakarti.Blog.project.model.AuthRequestDto;
import com.prakarti.Blog.project.model.LoginUserRequest;
import com.prakarti.Blog.project.model.RegisterUserRequest;
import com.prakarti.Blog.project.model.SignUpRequestDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {


    String login(String email, String password);

    User verifyEmailId(int parseInt, String substring);

    String signUp(SignUpRequestDto dto);
}
