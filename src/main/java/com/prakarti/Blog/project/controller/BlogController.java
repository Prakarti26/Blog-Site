package com.prakarti.Blog.project.controller;

import com.prakarti.Blog.project.entity.Blog;
import com.prakarti.Blog.project.exception.RecordNotFoundException;
import com.prakarti.Blog.project.model.CommonPaginationRequest;
import com.prakarti.Blog.project.model.CreateBlogRequest;
import com.prakarti.Blog.project.model.DBResponseEntity;
import com.prakarti.Blog.project.model.UpdateBlogRequest;
import com.prakarti.Blog.project.service.BlogService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/v1/create")
    public ResponseEntity<DBResponseEntity> createBlogCall(@Valid @RequestBody CreateBlogRequest createBlogRequest){
        log.info("Create Blog request received: {}", createBlogRequest.toString());

        try{
            Blog CreateBlogRequest = blogService.createBlog(createBlogRequest);
            DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                                                .data(CreateBlogRequest)
                                                .message("Blog Created Successfully")
                                                .build();
            log.info("Blog created Successfully: {} , createdBlog");
            return ResponseEntity.ok(dbResponseEntity);
        } catch (Exception e) {
            log.info("BlogController:createBlogCall something when wrong : {}",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/v1/update")
    public ResponseEntity<DBResponseEntity> updateBlogCall(@Valid @RequestBody UpdateBlogRequest updateBlogRequest){
        log.info("Update Blog request received: {}", updateBlogRequest.toString());

        try{
            Blog updatedBlog = blogService.updateBlog(updateBlogRequest);
            if(ObjectUtils.isEmpty((updatedBlog))){
                throw new RecordNotFoundException("NOT_FOUND","Blog with given ID is not Found");
            }
            DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                    .data(updatedBlog)
                    .message("Blog Updated Successfully")
                    .build();
            log.info("Blog is Updated Successfully: {}",updateBlogRequest.toString());
            return ResponseEntity.ok(dbResponseEntity);
        }catch (RecordNotFoundException e){
            log.debug("BlogController:updateBlogCall something when wrong : {}", e);
            throw e;
        }
        catch(Exception e){
            log.debug("BlogController:updateBlogCall something when wrong : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/v1/get/{blogId}")
    public ResponseEntity<DBResponseEntity> getBlogCall(@PathVariable String blogId){
        log.info("Get Blog request received: {}",blogId);
        try{
            Blog blog = blogService.getBlogById(blogId);
            if(ObjectUtils.isEmpty((blog))){
                throw new RecordNotFoundException("NOT_FOUND","Blog with given ID is not Found");
            }
            DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                                                .data(blog)
                                                .message("blog Found")
                                                .build();
            return ResponseEntity.ok(dbResponseEntity);
        } catch (RecordNotFoundException e) {
            log.debug("BlogController:getBlogCall something when wrong : {}", e);
            throw  e;
        }catch(Exception e){
            log.debug("BlogController:getBlogCall something when wrong : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/v1/delete/{blogId}")
    public ResponseEntity<DBResponseEntity> deleteBlogCall(@PathVariable String blogId){
        log.info("Delete Blog request received: {}",blogId);
        try{
            Blog blog = blogService.deleteBlog(blogId);
            if(ObjectUtils.isEmpty((blog))){
                throw new RecordNotFoundException("NOT_FOUND","Blog with given ID is not Found");
            }
            DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                                                .data(blog)
                                                .message("Blog is Deleted")
                                                .build();
            return ResponseEntity.ok(dbResponseEntity);
        } catch (RecordNotFoundException e) {
            log.debug("BlogController:deleteBlogCall something when wrong : {}", e);
            throw e;
        }catch(Exception e){
            log.debug("BlogController:deleteBlogCall something when wrong : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/v1/get_blogs/{userId}")
    public ResponseEntity<DBResponseEntity> getBlogsCall(@RequestParam(defaultValue = "0") Integer pageNo,
                                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                                         @RequestParam(defaultValue = "1") String userId,
                                                         @RequestParam(defaultValue = "id") String sortBy){
        log.info("Get Blog request received");
        try{
            CommonPaginationRequest commonPaginationRequest = CommonPaginationRequest.builder()
                                                                                    .pageNo(pageNo)
                                                                                    .pageSize(pageSize)
                                                                                    .sortBy(sortBy)
                                                                                    .value(userId)
                                                                                    .build();
            List<Blog> blogs = blogService.getBlogsByUserId(commonPaginationRequest);
            DBResponseEntity dbResponseEntity = DBResponseEntity.builder()
                                                                .data(blogs)
                                                                .message("Blogs Found")
                                                                .build();
            return ResponseEntity.ok(dbResponseEntity);
        } catch(Exception e){
            log.debug("BlogController:getBlogsCall something when wrong : {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
