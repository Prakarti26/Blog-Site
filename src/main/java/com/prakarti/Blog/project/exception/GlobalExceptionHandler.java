package com.prakarti.Blog.project.exception;

import com.prakarti.Blog.project.model.DBResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<DBResponseEntity> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException){
        DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                        .message(recordNotFoundException.getMessage())
                        .data(recordNotFoundException.getErrorCode()).
                        build();

        return new ResponseEntity<>(dbResponseEntity, HttpStatus.NOT_FOUND);
    }
}
