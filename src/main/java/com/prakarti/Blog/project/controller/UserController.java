package com.prakarti.Blog.project.controller;

import com.prakarti.Blog.project.config.EmailUtils;
import com.prakarti.Blog.project.model.AuthRequestDto;
import com.prakarti.Blog.project.entity.User;
import com.prakarti.Blog.project.entity.enums.AuthStatus;
import com.prakarti.Blog.project.exception.AuthenticationFailedException;
import com.prakarti.Blog.project.exception.RecordNotFoundException;
import com.prakarti.Blog.project.exception.UserAlreadyRegisterException;
import com.prakarti.Blog.project.model.*;
import com.prakarti.Blog.project.service.UserService;
import com.prakarti.Blog.project.utils.JwtUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailUtils emailUtils;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${app.mail.verification-link}")
    private String mailVerificationLink;

    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }


    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponseDto>  signup(@RequestBody SignUpRequestDto dto) {
        try {
            String jwtToken = userService.signUp(dto);
            AuthResponseDto authResponseDto = new AuthResponseDto(jwtToken, AuthStatus.USER_CREATING);
            return ResponseEntity.status(HttpStatus.CONTINUE).body(authResponseDto);
        } catch (Exception e) {
            AuthResponseDto authResponseDto = new AuthResponseDto(null, AuthStatus.USER_ALREADY_EXISTS);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(authResponseDto);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto dto) {
        var jwtToken = userService.login(dto.getUsername(), dto.getPassword());
        AuthResponseDto authResponseDto = new AuthResponseDto(jwtToken, AuthStatus.LOGIN_SUCCESS);
        return ResponseEntity.ok(authResponseDto);

    }

    @GetMapping("/verifyEmailId/{code}")
    public ResponseEntity<AuthResponseDto>  verifyEmailId(@PathVariable String code) {
        log.info("UserController:verifyEmailId request received: {}", code);
        try {
            System.out.println(Integer.parseInt(code.substring(0, 4)) + " : " + code.substring(4));
            User user = userService.verifyEmailId(Integer.parseInt(code.substring(0, 4)), code.substring(4));
            if (!Objects.isNull(user)) {
                String  jwtToken = JwtUtils.generateToken(user.getUsername());
                AuthResponseDto authResponseDto = new AuthResponseDto(jwtToken, AuthStatus.USER_VERIFIED_SUCCESSFULLY);
                return ResponseEntity.status(HttpStatus.CREATED).body(authResponseDto);
            } else {
                throw new RecordNotFoundException("User Not Present int the System", "USER_NOT_FOUND");
            }
        } catch (RecordNotFoundException e) {
            log.debug("UserController:verifyEmailId user not present in the System: {}", e);
            throw e;
        } catch (AuthenticationFailedException e) {
            log.debug("UserController:verifyEmailId Authentication Failed exception : {}", e);
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}


