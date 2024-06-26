package com.prakarti.Blog.project.exception;

import lombok.Data;

@Data
public class AuthenticationFailedException extends RuntimeException {

    public String errorCode;
    public AuthenticationFailedException(String message,String errorCode) {

        super(message);
        this.errorCode = errorCode;
    }
}
