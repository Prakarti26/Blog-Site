package com.prakarti.Blog.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class DBSResponseEntity<T> {

    T data;
    private String message;
}
