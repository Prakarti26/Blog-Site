package com.prakarti.Blog.project.service;

import com.prakarti.Blog.project.entity.Blog;
import com.prakarti.Blog.project.model.CommonPaginationRequest;
import com.prakarti.Blog.project.model.CreateBlogRequest;
import com.prakarti.Blog.project.model.UpdateBlogRequest;

import java.awt.print.Pageable;
import java.util.List;


public interface BlogService {



    Blog createBlog(CreateBlogRequest createBlogRequest) throws Exception;
    Blog updateBlog(UpdateBlogRequest updateBlogRequest)throws Exception;
    Blog deleteBlog(String blogId)throws Exception;

    Blog getBlogById(String blogId)throws Exception;

    List<Blog> getBlogsByUserId(CommonPaginationRequest commonPaginationRequest)throws Exception;


}
