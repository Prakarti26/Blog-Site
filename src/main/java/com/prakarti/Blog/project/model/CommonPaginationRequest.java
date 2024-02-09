package com.prakarti.Blog.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CommonPaginationRequest {
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String value;

}
