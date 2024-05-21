package com.prakarti.Blog.project.exception;

import com.prakarti.Blog.project.model.DBResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<DBResponseEntity> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException){
        DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                .message(recordNotFoundException.getMessage())
                .data(recordNotFoundException.getErrorCode())
                .build();
        return new ResponseEntity<>(dbResponseEntity, HttpStatus.NOT_FOUND);
    }
   @ExceptionHandler(UserAlreadyRegisterException.class)
    public ResponseEntity<DBResponseEntity> handleUserAlreadyRegisterException(UserAlreadyRegisterException userAlreadyRegisterException){
        DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                .message(userAlreadyRegisterException.getMessage())
                .data(userAlreadyRegisterException.getErrorCode())
                .build();
        log.debug("GlobalException:handleUserAlreadyRegisterException Authentication failed");

        return new ResponseEntity<>(dbResponseEntity, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<DBResponseEntity> handleAuthenticationFailedException(AuthenticationFailedException authenticationFailedException){
        DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                .message(authenticationFailedException.getMessage())
                .data(authenticationFailedException.getErrorCode())
                .build();
        log.debug("GlobalException:handleUserAlreadyRegisterException Authentication failed");
        return new ResponseEntity<>(dbResponseEntity, HttpStatus.UNAUTHORIZED);
    }
}
