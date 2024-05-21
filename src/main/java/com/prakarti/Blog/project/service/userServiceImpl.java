package com.prakarti.Blog.project.service;


import com.prakarti.Blog.project.config.EmailUtils;
import com.prakarti.Blog.project.entity.User;
import com.prakarti.Blog.project.exception.UserAlreadyRegisterException;

import com.prakarti.Blog.project.model.RegisterUserRequest;
import com.prakarti.Blog.project.model.SignUpRequestDto;
import com.prakarti.Blog.project.repository.UserRespository;
import com.prakarti.Blog.project.utils.AppUtils;
import com.prakarti.Blog.project.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class userServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;
    @Autowired
    private EmailUtils emailUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${app.mail.verification-link}")
    private String mailVerificationLink;

    @Autowired
    private AppUtils appUtils;

    private final AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String password) {
        var authToken = new UsernamePasswordAuthenticationToken(username,password);
        var authenticate = authenticationManager.authenticate(authToken);
        return JwtUtils.generateToken(((UserDetails)(authenticate.getPrincipal())).getUsername());
    }


    @Override
    public String signUp(SignUpRequestDto dto) {

        Optional<User>user = userRespository.findByUsername(dto.getUserName());
        if(!user.isEmpty()){
            throw new RuntimeException("User already exist");
        }

        var encodedPassword = passwordEncoder.encode(dto.getPassword());
        User newUser = User.builder()
                .username(dto.getUserName())
                .password(encodedPassword)
                .name(dto.getName())
                .role(dto.getRole())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isSocialRegister(0)
                .isAccountVerify(0)
                .otp(appUtils.get4DigitOtp())
                .build();

        User savedUser = userRespository.save(newUser);
        emailUtils.sendEmail(fromEmail,savedUser.getUsername(),"Email verification for our blogging website","Click on below link to verify your email\n" + mailVerificationLink + newUser.getOtp() + savedUser.getUserId());
        return JwtUtils.generateToken(newUser.getUsername());
    }


    @Override
    public User verifyEmailId(int otp, String userId) {
        System.out.println("User is finding...");
        User user = userRespository.findByUserIdAndOtp(userId, otp);
        System.out.println("User is found");
        if(Objects.isNull(user)){
            return null;
        }
        System.out.println("Status is changed");
        user.setIsAccountVerify(1);
        userRespository.save(user);
        System.out.println("Changes user is saved");
        return user;
    }


}
