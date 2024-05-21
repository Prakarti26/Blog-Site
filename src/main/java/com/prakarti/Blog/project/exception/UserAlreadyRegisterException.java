package com.prakarti.Blog.project.exception;


import lombok.Data;

@Data
public class UserAlreadyRegisterException extends RuntimeException {

    public String errorCode;
    public UserAlreadyRegisterException(String message) {

        super(message);
        this.errorCode = errorCode;
    }

}
