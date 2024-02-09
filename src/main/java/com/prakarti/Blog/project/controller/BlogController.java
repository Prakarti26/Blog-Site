package com.prakarti.Blog.project.controller;

import com.prakarti.Blog.project.entity.Blog;
import com.prakarti.Blog.project.exception.RecordNotFoundException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

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
}
