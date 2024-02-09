package com.prakarti.Blog.project.service;

import com.prakarti.Blog.project.entity.Blog;
import com.prakarti.Blog.project.model.UpdateBlogRequest;

import java.awt.print.Pageable;
import java.util.List;


public interface BlogService {



    Blog createBlog(Blog blog);
    Blog updateBlog(UpdateBlogRequest updateBlogRequest);
    Blog deleteBlog(String blogId);

    Blog getBlogById(String blogId);

    List<Blog> getBlogsByUserId(String userId, Pageable pageable);


}
