package com.prakarti.Blog.project.service;

import com.prakarti.Blog.project.model.UpdateBlogRequest;
import com.prakarti.Blog.project.repository.BlogRepository;
import com.prakarti.Blog.project.entity.Blog;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class blogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog createBlog(Blog blog){
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(UpdateBlogRequest updateBlogRequest){

        Blog blog = blogRepository.findByBlogId(updateBlogRequest.getBlogId());
        if(ObjectUtils.isEmpty(blog)){
            return null;
        }
        BeanUtils.copyProperties(updateBlogRequest,blog);
        blog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    @Override
    public Blog deleteBlog(String blogId){

        return blogRepository.deleteByBlogId(blogId);
    }

    @Override
    public Blog getBlogById(String blogId){
        return blogRepository.findByBlogId(blogId);
    }

    @Override
    public List<Blog> getBlogsByUserId(String userId, Pageable pageable){
        return blogRepository.findByUserId(userId,pageable);
    }


}
