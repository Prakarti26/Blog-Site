package com.prakarti.Blog.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class CommonPaginationRequest {
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String value;

}
