package com.prakarti.Blog.project.exception;


import lombok.Data;

@Data
public class RecordNotFoundException extends RuntimeException{


    public String errorCode;

    public RecordNotFoundException(String message,String errorCode){
        super(message);
        this.errorCode = errorCode;

    }
}
